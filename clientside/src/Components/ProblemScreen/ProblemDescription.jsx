import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import img from "../../assets/check.png";
import { getProblem } from "../../services/ProblemService";
import { getUserProblemById } from "../../services/UserProblemService";
import BisectionComponent from "./BisectionComponent";
import DirectEulerComponent from "./DirectEulerComponent";
import FivePointDerivativeComponent from "./FivePointDerivativeComponent";
import ImprovedEulerComponent from "./ImprovedEulerComponent";
import NewtonRaphsonComponent from "./NewtonRaphsonComponent";
import RegulaFalsiComponent from "./RegulaFalsiComponent";
import RichardsonComponent from "./RichardsonComponent";
import RungeKuttaComponent from "./RungeKuttaComponent";
import RungeKuttaNystromComponent from "./RungeKuttaNystromComponent";
import SimpsonComponent from "./SimpsonComponent";
import ThreePointDerivativeComponent from "./ThreePointDerivativeComponent";
import TrapezodialRuleComponent from "./TrapezodialRuleComponent";

const ProblemDescription = () => {
  const { id } = useParams();
  const [problemType, setProblemType] = useState("");
  const [problemTitle, setProblemTitle] = useState("");
  const [problemNumber, setProblemNumber] = useState("");
  const [problemDifficulty, setProblemDifficulty] = useState("");
  const [problemCategory, setProblemCategory] = useState("");
  const [problemDescription, setProblemDescription] = useState("");
  const [problemString, setProblemString] = useState("");
  const [problemMethod, setProblemMethod] = useState("");
  const [isSolved, setIsSolved] = useState(false);
  const [showCheckmark, setShowCheckmark] = useState(false);

  useEffect(() => {
    getProblem(id)
      .then((response) => {
        setProblemMethod(response.data.problemType);
        setProblemDescription(response.data.description);
        setProblemString(response.data.problemString);
        setProblemType(response.data.problemType);
        setProblemTitle(response.data.title);
        setProblemNumber(response.data.number);
        setProblemDifficulty(response.data.difficulty);
        setProblemCategory(response.data.category);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [id]);

  //Function to callback from children elements when a problem is solved to show the animation for
  //checkmark and solved text
  const handleProblemSolved = () => {
    setIsSolved(true);
    setShowCheckmark(true);
    getUserProblemById(id)
      .then((response) => {
        setIsSolved(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const renderProblem = (problemType) => {
    if (problemType === "Bisection") {
      return (
        <BisectionComponent
          isSolved={isSolved}
          problemString={problemString}
          problemMethod={problemMethod}
          problemCategory={problemCategory}
          onProblemSolved={handleProblemSolved}
          onResultReceived={handleResultReceived}
        ></BisectionComponent>
      );
    } else if (problemType === "Regula-Falsi") {
      return (
        <RegulaFalsiComponent
          isSolved={isSolved}
          problemString={problemString}
          problemMethod={problemMethod}
          problemCategory={problemCategory}
          onProblemSolved={handleProblemSolved}
          onResultReceived={handleResultReceived}
        ></RegulaFalsiComponent>
      );
    } else if (problemType === "Newton-Raphson") {
      return (
        <NewtonRaphsonComponent
          isSolved={isSolved}
          problemString={problemString}
          problemMethod={problemMethod}
          problemCategory={problemCategory}
          onProblemSolved={handleProblemSolved}
          onResultReceived={handleResultReceived}
        ></NewtonRaphsonComponent>
      );
    } else if (problemType === "Diakriti-Newton-Raphson") {
      return (
        <DiakritiNewtonRaphsonComponent
          isSolved={isSolved}
          problemString={problemString}
          problemMethod={problemMethod}
          problemCategory={problemCategory}
          onProblemSolved={handleProblemSolved}
          onResultReceived={handleResultReceived}
        ></DiakritiNewtonRaphsonComponent>
      );
    } else if (problemType === "Fixed-Point") {
      return (
        <FixedPointComponent
          isSolved={isSolved}
          problemString={problemString}
          problemMethod={problemMethod}
          problemCategory={problemCategory}
          onProblemSolved={handleProblemSolved}
          onResultReceived={handleResultReceived}
        ></FixedPointComponent>
      );
    } else if (problemType === "Trapezodial-Rule") {
      return (
        <TrapezodialRuleComponent
          isSolved={isSolved}
          problemString={problemString}
          problemMethod={problemMethod}
          problemCategory={problemCategory}
          onProblemSolved={handleProblemSolved}
          onResultReceived={handleResultReceived}
        ></TrapezodialRuleComponent>
      );
    } else if (problemType === "Simpson-Rule") {
      return (
        <SimpsonComponent
          isSolved={isSolved}
          problemString={problemString}
          problemMethod={problemMethod}
          problemCategory={problemCategory}
          onProblemSolved={handleProblemSolved}
          onResultReceived={handleResultReceived}
        ></SimpsonComponent>
      );
    } else if (problemType === "Three-Point-Derivative") {
      <ThreePointDerivativeComponent></ThreePointDerivativeComponent>;
    } else if (problemType === "Five-Point-Derivative") {
      <FivePointDerivativeComponent></FivePointDerivativeComponent>;
    } else if (problemType === "Richardson") {
      <RichardsonComponent></RichardsonComponent>;
    } else if (problemType === "Runge-Kutta") {
      <RungeKuttaComponent></RungeKuttaComponent>;
    } else if (problemType === "Runge-Kutta-Nystrom") {
      <RungeKuttaNystromComponent></RungeKuttaNystromComponent>;
    } else if (problemType === "Improved-Euler") {
      <ImprovedEulerComponent></ImprovedEulerComponent>;
    } else if (problemType === "Direct-Euler") {
      <DirectEulerComponent></DirectEulerComponent>;
    }
  };

  useEffect(() => {
    getUserProblemById(id)
      .then((response) => {
        setIsSolved(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [id]);

  const handleResultReceived = (result) => {
    if (result === true) {
      setShowCheckmark(true);
    }
  };

  return (
    <>
      <div>
        {isSolved || showCheckmark === true ? (
          <div className="checkmark">
            <img src={img}></img>
            <p>Solved</p>
          </div>
        ) : (
          <div></div>
        )}
      </div>
      <div>
        {problemNumber}
        {problemTitle}
        {problemDifficulty}
        {problemDescription}

        {problemString}
        {problemMethod}
      </div>

      <div>{renderProblem(problemType)}</div>
      <div>
        Tags:
        {problemCategory}
        {problemType}
      </div>
    </>
  );
};
export default ProblemDescription;
