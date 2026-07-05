import { forwardRef, useImperativeHandle, useState } from "react";
import useFetchDerivatives from "../../hooks/useFetchDerivatives";
import useFetchIsSolved from "../../hooks/useFetchIsSolved";
import useFetchRelatedAchievements from "../../hooks/useFetchRelatedAchivements";
import useFetchUserId from "../../hooks/useFetchUserId";
import useGenerateInputsDerivatives from "../../hooks/useGenerateInputsDerivatives";
import useGetTimeAndDate from "../../hooks/useGetTimeAndDate";
import useHandleInput from "../../hooks/useHandleInput";
import useResultTextHook from "../../hooks/useResultTextHook";
import useSaveAchievementOfUser from "../../hooks/useSaveAchievementOfUser";
import useSaveSolvedProblem from "../../hooks/useSaveSolvedProblem";
import useSetCallback from "../../hooks/useSetCallback";
import {
  saveSubmission,
  sendRichardsonData,
} from "../../services/SubmitService";
import FormInput from "../FormInput";
import KatexLabel from "./KatexLabel";
const RichardsonComponent = forwardRef((props, ref) => {
  const [result, setResult] = useState(false);
  const [resultText, setResultText] = useState("");
  const [isButtonDisabled, setButtonDisabled] = useState(false);
  const [hParameter, setHparameter] = useState(0);
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

  const { achievements } = useFetchRelatedAchievements(props);
  const { userId } = useFetchUserId();
  useFetchIsSolved(props.isSolved, setButtonDisabled);
  const { decideToSaveSolvedProblem } = useSaveSolvedProblem();
  const { submittedAt } = useGetTimeAndDate();
  const { setCallback } = useSetCallback(props);
  useResultTextHook(result);
  useGenerateInputsDerivatives(entries);
  const { input, inp, generalError, setGeneralError, handleInput } =
    useHandleInput();
  const { saveAchievementOfUser } = useSaveAchievementOfUser();

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
    hParameter,
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

  const submitRichardsonData = async () => {
    if (validateForm()) {
      await saveSubmission(submission).then((response) => {
        console.log(response.data);
      });
      const response = await sendRichardsonData(submissionData);
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

  useImperativeHandle(ref, () => ({
    submitData: submitRichardsonData,
  }));

  return (
    <>
      <div className="listOfDerivativeParams">
        <div className="params">
          <div className="labelDerivativeParams">
            <KatexLabel latex={`i:`}></KatexLabel>
          </div>
          <div className="list">{listOfCountingParameters}</div>
        </div>
        <div className="params">
          <div className="labelDerivativeParams">
            <KatexLabel latex={`x_i:`}></KatexLabel>
          </div>
          <div className="list">{listOfXiParameters}</div>
        </div>
        <div className="params">
          <div className="labelDerivativeParams">
            <KatexLabel latex={`f_i:`}></KatexLabel>
          </div>
          <div className="list">{listOfFiParameters}</div>
        </div>
      </div>
      <form name="inputForm" className="inputForm">
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
});
export default RichardsonComponent;
