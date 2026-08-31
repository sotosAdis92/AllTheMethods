import { forwardRef, useImperativeHandle, useState } from "react";
import { useParams } from "react-router-dom";
import useFetchIsSolved from "../../hooks/useFetchIsSolved";
import useFetchLinearSystems from "../../hooks/useFetchLinearSystems";
import useFetchRelatedAchievements from "../../hooks/useFetchRelatedAchivements";
import useFetchUserId from "../../hooks/useFetchUserId";
import useGenerateGershgorinInputs from "../../hooks/useGenerateGershgorinInputs";
import useGetTimeAndDate from "../../hooks/useGetTimeAndDate";
import useHandleInput from "../../hooks/useHandleInput";
import useResultTextHook from "../../hooks/useResultTextHook";
import useSaveAchievementOfUser from "../../hooks/useSaveAchievementOfUser";
import useSaveSolvedProblem from "../../hooks/useSaveSolvedProblem";
import useSetCallback from "../../hooks/useSetCallback";
import {
  saveSubmission,
  sendGershgorinCircles,
} from "../../services/SubmitService";
import FormInput from "../FormInput";

const GershgorinCirclesComponent = forwardRef((props, ref) => {
  const { id } = useParams();
  const [result, setResult] = useState(false);
  const [resultText, setResultText] = useState("");
  const [isButtonDisabled, setButtonDisabled] = useState(false);
  const [errorBool, setErrorBool] = useState(false);

  let text;
  const [values, setValues] = useState({
    entry: "",
  });
  var entries = [];
  const { problemId, problemData, matrix } = useFetchLinearSystems();
  const { achievements } = useFetchRelatedAchievements(props);
  const { userId } = useFetchUserId();
  useFetchIsSolved(props.isSolved, setButtonDisabled);
  const { input, inp, generalError, setGeneralError, handleInput } =
    useHandleInput();

  useGenerateGershgorinInputs(matrix, entries);
  const { saveAchievementOfUser } = useSaveAchievementOfUser();
  const { decideToSaveSolvedProblem } = useSaveSolvedProblem();
  const { submittedAt } = useGetTimeAndDate();
  const { setCallback } = useSetCallback(props);
  useResultTextHook(result);
  console.log(matrix);
  //Form Validation
  function validateForm() {
    let valid = true;
    if (inp.length != 2 * matrix.length || text === 0) {
      valid = false;
      setGeneralError("One or more inputs are empty");
      setErrorBool(true);
    } else {
      setGeneralError("");
      setErrorBool(true);
    }
    return valid;
  }

  useImperativeHandle(ref, () => ({
    submitData: submitGershgorinData,
  }));

  //Props passed in from parrent element
  let problemCategory = props.problemCategory;
  let variables = [];
  let equals = [];

  const submissionData = {
    inp,
    matrix,
    variables,
    equals,
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

  const submitGershgorinData = async () => {
    console.log(submissionData);
    if (validateForm()) {
      await saveSubmission(submission).then((response) => {
        console.log(response.data);
      });

      const response = await sendGershgorinCircles(submissionData);
      const result = response.data;
      console.log(result);
      setResult(result);
      setCallback(result);
      await decideToSaveSolvedProblem(result, savedProblem, setButtonDisabled);
      await saveAchievementOfUser(id, result, achievements);
    }
  };

  return (
    <>
      <form name="inputForm" className="inputForm">
        {entries.map((entry) => (
          <FormInput
            key={entry.id}
            {...entry}
            value={values[entry.name]}
            onChange={(e) => handleInput(entry.id, e)}
            error={errorBool}
          ></FormInput>
        ))}
      </form>
      <span className="generalError">{generalError}</span>
      <div>{props.isSolved ? <div></div> : <div>{resultText}</div>}</div>
    </>
  );
});
export default GershgorinCirclesComponent;
