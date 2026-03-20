import katex from "katex";
import "katex/dist/katex.min.css";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../../services/ProblemService";
import { sendSubmissionData } from "../../services/SubmitService";
import { getUser } from "../../services/UsersService";

const ProblemDescription = () => {
  const [description, setDescription] = useState("");
  const [functionString, setFunction] = useState("");
  const [category, setCategory] = useState("");
  const [difficulty, setDifficulty] = useState("");
  const [result, setResult] = useState(false);
  const [userId, setUserId] = useState(0);
  const { id } = useParams();
  const [iterations, setIterations] = useState(0);
  const [problemString, setProblemString] = useState("");
  const [problemSpaceA, setProblemSpaceA] = useState(0);
  const [problemSpaceB, setProblemSpaceB] = useState(0);
  const [input, setInput] = useState([]);
  const [inp, setInp] = useState([]);
  var x = ``;
  var inputs = [];

  useEffect(() => {
    getProblem(id)
      .then((response) => {
        setDescription(response.data.description);
        setFunction(response.data.problemString);
        setCategory(response.data.category);
        setDifficulty(response.data.difficulty);
        console.log(response.data.description);
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
    iterations,
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
    console.log(iterations);
  }

  function detectFunction(functionString) {
    const string = functionString.toString();
    setProblemString(string);
  }

  for (let i = 0; i < iterations; i++) {
    x = `x${i}`;
    inputs.push(
      <div key={i}>
        <span id={x}>{x}=</span>
        <input
          key={i}
          maxlength="5"
          name={`X${i}`}
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
    const inp = input.map((pair) => pair[1]);
    setInput([...input]);
    setInp(inp);
    console.log(input);
    console.log(inp);
  }

  const setResultText = () => {
    {
      result ? (
        <div className="resultTrue">Correct Answer</div>
      ) : (
        <div className="resultFalse">Numbers Are not Correct</div>
      );
    }
  };

  useEffect(() => {
    detectIterations(description);
    detectFunction(functionString);
    detectSpace(description);
  }, [description]);

  function handleSubmit() {
    //sendSubmission(submission);
    sendSubmissionData(submissionData).then((response) => {
      console.log(response.data);
      setResult(response.data);
      setResultText();
    });
  }

  useEffect(() => {
    katex.render(functionString, document.getElementById("element"), {
      throwOnError: false,
    });
  });

  return (
    <>
      <button className="submissionButton" onClick={handleSubmit}>
        <span>Submit</span>
      </button>
      <p id="description" className="problemDesc">
        {description}
      </p>
      <span>{setResultText()}</span>
      <p className="katex" id="element"></p>
      <ol>{inputs}</ol>
      <div className="message"></div>
      <div className="problemInformationDisplay">
        <span className="">Problem Tags:</span>
        <p className="problemCategoryTag">{category}</p>
        <p className="problemDifficultyTag">{difficulty}</p>
      </div>
    </>
  );
};
export default ProblemDescription;
