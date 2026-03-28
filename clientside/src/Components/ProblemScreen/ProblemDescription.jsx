import katex from "katex";
import "katex/dist/katex.min.css";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../../services/ProblemService";
import { sendSubmissionData } from "../../services/SubmitService";
import { getUser } from "../../services/UsersService";
import BisectionComponent from "./BisectionComponent";

const ProblemDescription = () => {
  const [description, setDescription] = useState("");
  const [functionString, setFunction] = useState("");
  const [category, setCategory] = useState("");
  const [difficulty, setDifficulty] = useState("");
  const [resultText, setResultTextFunc] = useState("");
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
  function callComponent(problemType) {
    if (problemType === "Bisection") {
      return <BisectionComponent interations={iterations}></BisectionComponent>;
    } else if (problemType === "Regula Falsi") {
    } else if (problemType === "Newton - Raphson") {
    } else if (problemType === "Non-Linear Newton Method") {
    } else if (problemType === "False Point") {
    }
  }

  useEffect(() => {
    detectIterations(description);
    detectFunction(functionString);
    detectSpace(description);
  }, [description]);

  function handleSubmit() {
    //sendSubmission(submission);
    sendSubmissionData(submissionData).then((response) => {
      console.log(response.data);
      const result = response.data;
      setResult(result);
      console.log(result);
      setResultText(result);
      console.log(submissionData);
    });
  }

  function setResultText(result) {
    if (result) {
      setResultTextFunc("Correct Numbers!");
    } else {
      setResultTextFunc("Incorrect Numbers");
    }
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
      <p className="katex" id="element"></p>
      {callComponent()}
      <div className="message" id="message">
        {resultText}
      </div>
      <div className="problemInformationDisplay">
        <span className="tags">Problem Tags:</span>
        <p className="problemCategoryTag">{category}</p>
        <p className="problemDifficultyTag">{difficulty}</p>
      </div>
    </>
  );
};
export default ProblemDescription;
