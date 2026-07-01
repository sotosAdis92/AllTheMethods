import { useState } from "react";
import { useParams } from "react-router-dom";
import useFetchIsSolved from "../../hooks/useFetchIsSolved";
import useFetchRelatedAchievements from "../../hooks/useFetchRelatedAchivements";
import useFetchUserId from "../../hooks/useFetchUserId";
import useFetchXZeroProblems from "../../hooks/useFetchXZeroProblems";
import useGenerateInputsBisection from "../../hooks/useGenerateInputsBisection";
import useGetTimeAndDate from "../../hooks/useGetTimeAndDate";
import useHandleInput from "../../hooks/useHandleInput";
import useResultTextHook from "../../hooks/useResultTextHook";
import useSaveAchievementOfUser from "../../hooks/useSaveAchievementOfUser";
import useSaveSolvedProblem from "../../hooks/useSaveSolvedProblem";
import useSetCallback from "../../hooks/useSetCallback";

import {
  saveSubmission,
  sendNewtonRaphsonData,
} from "../../services/SubmitService";
import FormInput from "../FormInput";

const NewtonRaphsonComponent = (props) => {
  const { id } = useParams();
  const [result, setResult] = useState(false);
  const [resultText, setResultText] = useState("");
  const [isButtonDisabled, setButtonDisabled] = useState(false);
  let text;
  const [values, setValues] = useState({
    entry: "",
  });
  var entries = [];
  console.log(props.isSolved);

  const { problemId, problemData, xoParameter, iterations, functionString } =
    useFetchXZeroProblems();
  useResultTextHook(result);
  const { achievements } = useFetchRelatedAchievements(props);
  const { userId } = useFetchUserId();
  useFetchIsSolved(props.isSolved, setButtonDisabled);
  const { input, inp, generalError, setGeneralError, handleInput } =
    useHandleInput();
  useGenerateInputsBisection(iterations, entries);
  const { saveAchievementOfUser } = useSaveAchievementOfUser();
  const { decideToSaveSolvedProblem } = useSaveSolvedProblem();
  const { submittedAt } = useGetTimeAndDate();
  const { setCallback } = useSetCallback(props);
  useResultTextHook(result);

  console.log(achievements);
  console.log(input);
  console.log(result);
  console.log(id);

  function validateForm() {
    let valid = true;
    if (inp.length != iterations || text === 0) {
      valid = false;
      setGeneralError("One or more inputs are empty");
    } else {
      setGeneralError("");
    }
    return valid;
  }

  //Props passed in from parrent element
  let problemMethod = props.problemMethod;
  let problemString = functionString;
  let problemCategory = props.problemCategory;

  //Submitting data based on what method we have rendered to reduce if checks for both client and server
  const submissionData = {
    inp,
    problemMethod,
    problemString,
    iterations,
    xoParameter,
  };

  const submission = {
    problemId,
    userId,
    submittedAt,
  };

  const savedProblem = {
    userId,
    problemId,
    problemCategory,
  };

  const submitNewtonRaphsonData = async () => {
    if (validateForm()) {
      await saveSubmission(submission).then((response) => {
        console.log(response.data);
      });
      const response = await sendNewtonRaphsonData(submissionData);
      const result = response.data;
      setResult(result);
      setCallback(result);
      await decideToSaveSolvedProblem(result, savedProblem, setButtonDisabled);
      await saveAchievementOfUser(result, achievements);
    }
  };

  return (
    <>
      <button
        type="button"
        disabled={isButtonDisabled}
        onClick={() => submitNewtonRaphsonData()}
      >
        Submit
      </button>
      <div>For: {problemData.iterations} iterations</div>
      <div>With a Xo = {problemData.xoParameter}</div>
      <form name="inputForm">
        {entries.map((entry) => (
          <FormInput
            key={entry.id}
            {...entry}
            value={values[entry.name]}
            onChange={(e) => handleInput(entry.id, e)}
          ></FormInput>
        ))}
      </form>
      <span className="generalError">{generalError}</span>
      <div>{props.isSolved ? <div></div> : <div>{resultText}</div>}</div>
    </>
  );
};
export default NewtonRaphsonComponent;
