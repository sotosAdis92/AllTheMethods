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
  sendFixedPointData,
} from "../../services/SubmitService";
import FormInput from "../FormInput";

const FixedPointComponent = (props) => {
  const { id } = useParams();
  const [result, setResult] = useState(false);
  const [resultText, setResultText] = useState("");
  const [isButtonDisabled, setButtonDisabled] = useState(false);
  let text;
  const [values, setValues] = useState({
    entry: "",
  });
  var entries = [];

  const { problemId, problemData, xoParameter, iterations, functionString } =
    useFetchXZeroProblems();
  const { achievements } = useFetchRelatedAchievements(props);
  const { userId } = useFetchUserId();
  useFetchIsSolved(props.isSolved, setButtonDisabled);
  const { input, inp, generalError, setGeneralError, handleInput } =
    useHandleInput();
  const { saveAchievementOfUser } = useSaveAchievementOfUser();
  useGenerateInputsBisection(iterations, entries);
  const { decideToSaveSolvedProblem } = useSaveSolvedProblem();
  const { submittedAt } = useGetTimeAndDate();
  const { setCallback } = useSetCallback(props);
  useResultTextHook(result);

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
  const submitFixedPointData = async () => {
    if (validateForm()) {
      await saveSubmission(submission).then((response) => {
        console.log(response.data);
      });
      const response = await sendFixedPointData(submissionData);
      const resultOfServer = response.data;
      setResult(resultOfServer);
      await decideToSaveSolvedProblem(result);
      await saveAchievementOfUser(result);
    }
  };

  return (
    <>
      <button
        type="button"
        disabled={isButtonDisabled}
        onClick={() => submitFixedPointData()}
        className="submitButton"
      >
        Submit
      </button>
      <div className="iterationsDiv">
        For: {problemData.iterations} iterations
      </div>
      <div>with Xo = {problemData.xoParameter}</div>
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
export default FixedPointComponent;
