import { useState } from "react";
import useFetchIntegrals from "../../hooks/useFetchIntergrals";
import useFetchIsSolved from "../../hooks/useFetchIsSolved";
import useFetchRelatedAchievements from "../../hooks/useFetchRelatedAchivements";
import useFetchUserId from "../../hooks/useFetchUserId";
import useGenerateTrapezodialInputs from "../../hooks/useGenerateTrapezodialInputs";
import useGetTimeAndDate from "../../hooks/useGetTimeAndDate";
import useHandleInput from "../../hooks/useHandleInput";
import useResultTextHook from "../../hooks/useResultTextHook";
import useSaveAchievementOfUser from "../../hooks/useSaveAchievementOfUser";
import useSaveSolvedProblem from "../../hooks/useSaveSolvedProblem";
import useSetCallback from "../../hooks/useSetCallback";
import {
  saveSubmission,
  sendTrapezodialData,
} from "../../services/SubmitService";
import FormInput from "../FormInput";

const TrapezodialRuleComponent = (props) => {
  const [result, setResult] = useState(false);
  const [isButtonDisabled, setButtonDisabled] = useState(false);
  const [resultText, setResultText] = useState("");
  let text;
  const [values, setValues] = useState({
    entry: "",
  });
  var entries = [];

  const {
    problemId,
    problemData,
    hParameter,
    integrationSpaceA,
    integrationSpaceB,
  } = useFetchIntegrals();
  const { achievements } = useFetchRelatedAchievements(props);
  const { userId } = useFetchUserId();
  useFetchIsSolved(props.isSolved, setButtonDisabled);
  const { input, inp, generalError, setGeneralError, handleInput } =
    useHandleInput();
  const { saveAchievementOfUser } = useSaveAchievementOfUser();
  const { decideToSaveSolvedProblem } = useSaveSolvedProblem();
  const { submittedAt } = useGetTimeAndDate();
  const { setCallback } = useSetCallback(props);
  useResultTextHook(result);
  useGenerateTrapezodialInputs(entries, integrationSpaceA, integrationSpaceB);

  function validateForm() {
    let valid = true;
    if (inp.length != integrationPointB + integrationPointA) {
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
    hParameter,
    integrationPointA,
    integrationPointB,
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

  const submitTrapezodialData = async () => {
    if (validateForm()) {
      await saveSubmission(submission).then((response) => {
        console.log(response.data);
      });
      const response = await sendTrapezodialData(submissionData);
      const result = response.data;
      setResult(result);
      setCallback(result);
      await decideToSaveSolvedProblem(result);
      await saveAchievementOfUser(result);
    }
  };

  return (
    <>
      <form name="inputForm" id="form" className="inputForm">
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
export default TrapezodialRuleComponent;
