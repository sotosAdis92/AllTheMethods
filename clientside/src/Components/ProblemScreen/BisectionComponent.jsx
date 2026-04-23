import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../../services/ProblemService";
import {
  saveSubmission,
  sendSubmissionData,
} from "../../services/SubmitService";
import { getUser } from "../../services/UsersService";
import FormInput from "../FormInput";
const BisectionComponent = () => {
  const { id } = useParams();
  const [description, setDescription] = useState("");
  const [problemData, setProblemData] = useState("");
  const [problemString, setProblemString] = useState("");
  const [problemMethod, setProblemMethod] = useState("");
  const [iterations, setIterations] = useState("");
  const [problemSpaceA, setProblemSpaceA] = useState("");
  const [problemSpaceB, setProblemSpaceB] = useState("");
  const [userId, setUsersId] = useState("");
  const [input, setInput] = useState([]);
  const [inp, setInputI] = useState([]);
  const [problemId, setProblemId] = useState(0);
  const [generalError, setGeneralError] = useState("");
  const [result, setResult] = useState("");
  let text;
  //var inputsI = []; //Create the array to store the input fields
  const [values, setValues] = useState({
    entry: "",
  });
  var entries = [];

  useEffect(() => {
    getProblem(id)
      .then((response) => {
        setProblemId(response.data.id);
        setDescription(response.data.description);
        const problemDataConverted = JSON.parse(response.data.problemData);
        setProblemData(problemDataConverted);
        setProblemString(response.data.problemString);
        setProblemMethod(response.data.problemType);
        setIterations(problemDataConverted.iterations);
        setProblemSpaceA(problemDataConverted.problemSpaceA);
        setProblemSpaceB(problemDataConverted.problemSpaceB);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [id]);

  useEffect(() => {
    getUser().then((response) => {
      setUsersId(response.data.id);
    });
  });

  for (let i = 0; i < iterations; i++) {
    entries.push({
      id: i,
      placeholder: `x${i}`,
      type: "number",
      label: `x${i} = `,
      name: "",
      i: { i },
      errorMessage: `Input x${i} cannot be empty`,
      required: true,
      pattern: /^\d+(\.\d+)*$/,
    });
  }

  //Implement input generation based on how many iterations you have
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
  //function that takes in an index and the inputed value and either when the user enters a new value puts it into the array or replaces it
  //later it sorts it for the index value so that x0 = index 0 ... x1 = index 1 ... xn = index n
  //creates a copy and saves it
  function handleInput(i, e) {
    const value = Number(e.target.value);
    const indexOfNumber = input.findIndex(
      (inputedNumber) => inputedNumber[0] === i,
    );
    if (indexOfNumber !== -1) {
      input[indexOfNumber] = [i, value];
    } else {
      input.push([i, Number(e.target.value)]);
    }
    input.sort();
    const inp = input.map((num) => num[1]);
    setInput([...input]);
    setInputI(inp);

    console.log(input);
    console.log(inp);

    if (inp.length >= 1) {
      setGeneralError("");
    }
  }

  const d = new Date();
  let date = d.toLocaleDateString();
  let time = d.toLocaleTimeString();
  let submittedAt = date + " " + time;

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

  const submitBisectionData = (e) => {
    if (validateForm()) {
      console.log(submissionData);
      console.log(submission);
      saveSubmission(submission).then((response) => {
        console.log(response.data);
      });
      sendSubmissionData(submissionData).then((response) => {
        console.log(response.data);
      });
    }
  };
  return (
    <>
      <button type="button" onClick={() => submitBisectionData()}>
        Submit
      </button>
      <div>
        {description} {problemString} with the {problemMethod} Method
      </div>
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
      <span>{generalError}</span>
    </>
  );
};

export default BisectionComponent;
