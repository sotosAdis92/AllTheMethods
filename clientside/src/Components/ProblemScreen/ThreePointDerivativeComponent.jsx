import { useState } from "react";
import { useParams } from "react-router-dom";
import img from "../../assets/arrowup.png";
import useGenerateInputsDerivatives, {
  default as useFetchDerivatives,
} from "../../hooks/useFetchDerivatives";
import useFetchIsSolved from "../../hooks/useFetchIsSolved";
import useFetchRelatedAchievements from "../../hooks/useFetchRelatedAchivements";
import useFetchUserId from "../../hooks/useFetchUserId";
import useGetTimeAndDate from "../../hooks/useGetTimeAndDate";
import useHandleInput from "../../hooks/useHandleInput";
import useResultTextHook from "../../hooks/useResultTextHook";
import useSaveAchievementOfUser from "../../hooks/useSaveAchievementOfUser";
import useSaveSolvedProblem from "../../hooks/useSaveSolvedProblem";
import useSetCallback from "../../hooks/useSetCallback";
import {
  saveSubmission,
  sendThreePointDerivativeData,
} from "../../services/SubmitService";
import FormInput from "../FormInput";

const ThreePointDerivativeComponent = (props) => {
  const { id } = useParams();
  const [result, setResult] = useState(false);
  const [resultText, setResultText] = useState("");
  const [isButtonDisabled, setButtonDisabled] = useState(false);
  let text;
  const [values, setValues] = useState({
    entry: "",
  });
  var entries = [];

  const {
    problemId,
    problemData,
    iterations,
    xZero,
    countingParameters,
    xiParameters,
    fiParameters,
    typeOfDerivative,
  } = useFetchDerivatives();

  const { input, inp, generalError, setGeneralError, handleInput } =
    useHandleInput();
  const { saveAchievementOfUser } = useSaveAchievementOfUser();
  const { achievements } = useFetchRelatedAchievements(props);
  const { userId } = useFetchUserId();
  useFetchIsSolved(props.isSolved, setButtonDisabled);
  const { decideToSaveSolvedProblem } = useSaveSolvedProblem();
  const { submittedAt } = useGetTimeAndDate();
  const { setCallback } = useSetCallback(props);
  useResultTextHook(result);
  useGenerateInputsDerivatives(entries);

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
  let problemMethod = props.problemMethod;
  let problemString = props.problemString;
  let problemCategory = props.problemCategory;

  //Submitting data based on what method we have rendered to reduce if checks for both client and server
  const submissionData = {
    inp,
    problemMethod,
    problemString,
    iterations,
    countingParameters,
    xiParameters,
    fiParameters,
    xZero,
    typeOfDerivative,
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

  const submitThreePointData = async () => {
    if (validateForm()) {
      await saveSubmission(submission).then((response) => {
        console.log(response.data);
      });
      const response = sendThreePointDerivativeData(submissionData);
      const result = response.data;
      setResult(result);
      setCallback(result);
      await decideToSaveSolvedProblem(result, savedProblem, setButtonDisabled);
      await saveAchievementOfUser(result, achievements);
    }
  };

  const listOfXiParameters = xiParameters.map((parameter, i) => (
    <div key={i} className="xiParameters">
      {parameter}
    </div>
  ));

  const listOfFiParameters = fiParameters.map((parameter, i) => (
    <div key={i} className="fiParameters">
      {parameter}
    </div>
  ));

  const listOfCountingParameters = countingParameters.map((parameter, i) => (
    <div key={i} className="countingParameters">
      {parameter}
    </div>
  ));

  return (
    <>
      <button
        type="button"
        disabled={isButtonDisabled}
        onClick={() => submitThreePointData()}
        className="submitButton"
      >
        <img src={img}></img>
        Submit
      </button>
      <div className="cParams">i:{listOfCountingParameters}</div>
      <div className="xParams">xi:{listOfXiParameters}</div>
      <div className="fParams">fi:{listOfFiParameters}</div>
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

export default ThreePointDerivativeComponent;
