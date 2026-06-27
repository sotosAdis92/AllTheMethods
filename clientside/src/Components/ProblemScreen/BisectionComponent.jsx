import { useState } from "react";
import { useParams } from "react-router-dom";
import useFetchIsSolved from "../../hooks/useFetchIsSolved";
import useFetchRelatedAchievements from "../../hooks/useFetchRelatedAchivements";
import useFetchSpaceProblems from "../../hooks/useFetchSpaceProblems";
import useFetchUserId from "../../hooks/useFetchUserId";
import useHandleInput from "../../hooks/useHandleInput";
import useSaveAchievementOfUser from "../../hooks/useSaveAchievementOfUser";
import { decideResultText } from "../../services/GeneralFunctions";
import {
  saveSubmission,
  sendSubmissionData,
} from "../../services/SubmitService";
import { saveSolvedProblem } from "../../services/UserProblemService";
import FormInput from "../FormInput";

const BisectionComponent = (props) => {
  const { id } = useParams();
  const [result, setResult] = useState(false);
  const [resultText, setResultText] = useState("");
  const [isButtonDisabled, setButtonDisabled] = useState(false);
  let text;
  const [values, setValues] = useState({
    entry: "",
  });
  var entries = [];

  const { problemId, problemData, iterations, problemSpaceA, problemSpaceB } =
    useFetchSpaceProblems();
  const { achievements } = useFetchRelatedAchievements(props);
  const { userId } = useFetchUserId();
  useFetchIsSolved(props.isSolved, setButtonDisabled);
  const { input, inp, generalError, setGeneralError, handleInput } =
    useHandleInput();
  const { saveAchievementOfUser } = useSaveAchievementOfUser();
  console.log(achievements);
  console.log(input);
  console.log(result);
  console.log(id);

  //Implement input generation based on how many iterations you have
  for (let i = 0; i < iterations; i++) {
    entries.push({
      id: i,
      placeholder: `x${i}`,
      type: "number",
      label: `x${i} = `,
      name: "",
      i: { i },
      required: true,
    });
  }

  //Form Validation
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

  //Setting up the local time objects for the submission
  const d = new Date();
  let date = d.toLocaleDateString();
  let time = d.toLocaleTimeString();
  let submittedAt = date + " " + time;

  //Props passed in from parrent element
  let problemMethod = props.problemMethod;
  let problemString = props.problemString;
  let problemCategory = props.problemCategory;

  //Submitting data based on what method we have rendered to reduce if checks for both client and server
  const submissionData = {
    inp,
    problemMethod,
    problemString,
    iterations,
    problemSpaceA,
    problemSpaceB,
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

  const submitBisectionData = async () => {
    if (validateForm()) {
      await saveSubmission(submission).then((response) => {
        console.log(response.data);
      });

      const response = await sendSubmissionData(submissionData);
      const result = response.data;
      setResult(result);
      decideResultText(result);
      setCallback(result);
      await decideToSaveSolvedProblem(result);
      await saveAchievementOfUser(result);
    }
  };

  const setCallback = (result) => {
    if (props.onResultReceived) {
      props.onResultReceived(result);
    }
  };

  //Function to save or not to save the problem based on the result that is returned by the server
  const decideToSaveSolvedProblem = (result) => {
    if (result === true) {
      saveSolvedProblem(savedProblem).then((response) => {
        console.log(response.data);
      });
      setButtonDisabled(true);
    } else {
      return;
    }
  };

  return (
    <>
      <button
        type="button"
        disabled={isButtonDisabled}
        onClick={() => submitBisectionData()}
      >
        Submit
      </button>
      <div>For: {problemData.iterations} iterations</div>
      <div>
        In the Space [{problemData.problemSpaceA},{problemData.problemSpaceB}]
      </div>
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

export default BisectionComponent;
