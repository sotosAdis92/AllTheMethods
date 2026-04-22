import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../../services/ProblemService";
import { getUser } from "../../services/UsersService";
const BisectionComponent = () => {
  const { id } = useParams();
  const [description, setDescription] = useState("");
  const [problemData, setProblemData] = useState("");
  const [problemString, setProblemString] = useState("");
  const [problemMethod, setProblemMethod] = useState("");
  const [iterations, setIterations] = useState("");
  const [problemSpaceA, setProblemSpaceA] = useState("");
  const [problemSpaceB, setProblemSpaceB] = useState("");
  const [usersId, setUsersId] = useState("");
  const [input, setInput] = useState([]);
  const [inputI, setInputI] = useState([]);
  let text;
  var inputs = []; //Create the array to store the input fields
  useEffect(() => {
    getProblem(id)
      .then((response) => {
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
      //console.log(response.data.id);
      setUsersId(response.data.id);
    });
  });
  //Implement input generation based on how many iterations you have
  for (let i = 0; i < iterations; i++) {
    inputs.push(
      <div key={i}>
        <input
          type="text"
          maxLength={5}
          value={text}
          onChange={(e) => handleInput(i, e)}
        ></input>
      </div>,
    );
  }

  function validateForm() {
    let valid = true;
    if (inputI.length != iterations) {
      valid = false;
    }
    return valid;
  }
  //function that takes in an index and the inputed value and either when the user enters a new value puts it into the array or replaces it
  //later it sorts it for the index value so that x0 = index 0 ... x1 = index 1 ... xn = index n
  //creates a copy and saves it
  function handleInput(i, e) {
    const indexOfNumber = input.findIndex(
      (inputedNumber) => inputedNumber[0] === i,
    );
    if (indexOfNumber !== -1) {
      input[indexOfNumber] = [i, Number(e.target.value)];
    } else {
      input.push([i, Number(e.target.value)]);
    }
    input.sort();
    const inputI = input.map((num) => num[1]);
    setInput([...input]);
    setInputI(inputI);

    console.log(input);
    console.log(inputI);
  }
  const d = new Date();
  let date = d.toLocaleDateString();
  let time = d.toLocaleTimeString();
  let datetime = date + " " + time;

  //Submitting data based on what method we have rendered to reduce if checks for both client and server
  const submissionData = {
    inputI,
    problemMethod,
    problemString,
    iterations,
    problemSpaceA,
    problemSpaceB,
  };

  const submission = {
    id,
    usersId,
    datetime,
  };

  const submitBisectionData = () => {
    if (validateForm()) {
      console.log(submissionData);
      console.log(submission);
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
      {inputs}
    </>
  );
};

export default BisectionComponent;
