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
  const input = [];
  var inputs = [];
  var uniq = [];

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

  const submissionData = {};

  function detectSpace(description) {
    const match = description?.match(/\[(\d+),(\d+)\]/);
    const a = match?.[1] ?? null;
    const b = match?.[2] ?? null;
    console.log(a, b);
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
        <input key={i} onChange={(e) => handleInputs(i, e)}></input>
      </div>,
    );
  }

  function handleInputs(i, e) {
    const exists = input.findIndex((item) => item[0] === i);
    if (exists !== -1) {
      input[exists] = [i, e.target.value];
    } else {
      input.push([i, e.target.value]);
    }
  }

  function detectProblem(description) {
    const string = description.match(/[X\d]+\^?\d*\s*[-+*/]\s*\d*X?/);
    const problemString = string;
    const problemS = String(problemString);
    console.log(problemS);
  }

  useEffect(() => {
    detectIterations(description);
    detectProblem(description);
    detectSpace(description);
  });
  function handleSubmit() {
    console.log(submission);
    //sendSubmission(submission);
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
