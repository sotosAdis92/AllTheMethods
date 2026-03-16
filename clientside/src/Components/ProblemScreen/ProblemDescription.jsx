import "katex/dist/katex.min.css";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../../services/ProblemService";
import { getUser } from "../../services/UsersService";

const ProblemDescription = () => {
  const [description, setDescription] = useState("");
  const [userId, setUserId] = useState(0);
  const { id } = useParams();
  const [numberIterations, setIterations] = useState(0);
  const [problemString, setProblemString] = useState("");
  const [problemSpaceA, setProblemSpaceA] = useState(0);
  const [problemSpaceB, setProblemSpaceB] = useState(0);
  const [input, setInput] = useState([]);
  var inp = [];
  var inputs = [];

  useEffect(() => {
    getProblem(id)
      .then((response) => {
        setDescription(response.data.description);
        console.log(description);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [id]);

  const userIdFunction = () => {
    getUser()
      .then((response) => {
        setUserId(response.data.id);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  useEffect(() => {
    userIdFunction();
  }, []);

  const now = new Date();
  const date = now.getDate();
  const year = now.getFullYear();
  const month = now.getMonth();

  const wholeDate = date + "/" + (month + 1) + "/" + year;

  const submission = {
    id,
    userId,
    wholeDate,
  };

  const submissionData = {
    problemString,
    problemSpaceA,
    problemSpaceB,
    numberIterations,
    inp,
  };

  function detectSpace(description) {
    const match = description?.match(/\[(\d+),(\d+)\]/);
    const problemSpaceA = match?.[1] ?? null;
    const problemSpaceB = match?.[2] ?? null;
    setProblemSpaceA(parseInt(problemSpaceA));
    setProblemSpaceB(parseInt(problemSpaceB));
    console.log(problemSpaceA, problemSpaceB);
  }

  function detectIterations(description) {
    const string = description.match(/[0-9]\siterations/);
    const iterationsString = String(string);
    const iterations = iterationsString.match(/[0-9]/);
    setIterations(parseInt(iterations));
    console.log(numberIterations);
  }

  for (let i = 0; i < numberIterations; i++) {
    inputs.push(
      <div key={i}>
        <span>X{i}=</span>
        <input
          key={i}
          maxlength="4"
          onChange={(e) => handleInputs(i, e)}
        ></input>
      </div>,
    );
  }

  function handleInputs(i, e) {
    const exists = input.findIndex((item) => item[0] === i);

    if (exists !== -1) {
      input[exists] = [i, Number(e.target.value)];
    } else {
      input.push([i, Number(e.target.value)]);
    }
    inp = input.map((pair) => pair[1]);
    setInput(input);
    console.log(input);
    console.log(inp);
  }

  function detectProblem(description) {
    const string = description.match(/[X\d]+\^?\d*\s*[-+*/]\s*\d*X?/);
    const problemStrings = string;
    const problemString = String(problemStrings);
    setProblemString(problemString);
    console.log(problemString);
  }

  useEffect(() => {
    detectIterations(description);
    detectProblem(description);
    detectSpace(description);
  });
  function handleSubmit() {
    console.log(submission);
    console.log(submissionData);
    //sendSubmission(submission);
    //sendSubmissionData(submissionData);
  }

  return (
    <>
      <button onClick={handleSubmit}>Submit</button>
      <p>{description}</p>
      <ol>{inputs}</ol>
    </>
  );
};
export default ProblemDescription;
