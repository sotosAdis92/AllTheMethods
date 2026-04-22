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
        <input type="text" onChange={(e) => handleInput(i, e)}></input>
      </div>,
    );
  }

  //Function for putting the inputs in the correct place in the array
  function handleInput(i, e) {
    const index = input.findIndex((item) => item[0] === i); //search the array to find if the index is in there
    if (index !== -1) {
      //if the index does already exist in the array
      input[index] = [i, Number(e.target.value)]; //overright the previous value of it
    } else {
      //if it does not exist within the array
      input.push([i, Number(e.target.value)]); //put the new value to the correct position
    }
    const inputI = input.map((index) => index[1]); //create a new array where only the values are, no indexes
    setInput([...input]); //copy the indexes array
    setInputI(inputI);
    console.log(inputI);
  }
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
  };

  const submitBisectionData = async () => {
    console.log(submissionData);
    console.log(submission);
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
