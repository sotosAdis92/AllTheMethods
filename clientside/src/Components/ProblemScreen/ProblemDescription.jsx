import katex from "katex";
import "katex/dist/katex.min.css";
import { useEffect, useRef, useState } from "react";
import { useParams } from "react-router-dom";
import img2 from "../../assets/1374863.png";
import img from "../../assets/check.png";
import { getProblem } from "../../services/ProblemService";
import { getUserProblemById } from "../../services/UserProblemService";
import ProblemDifficulty from "../ProblemDifficulty";
import BisectionComponent from "./BisectionComponent";
import DiakritiNewtonRaphsonComponent from "./DiakritiNewtonRaphsonComponent";
import DirectEulerComponent from "./DirectEulerComponent";
import FivePointDerivativeComponent from "./FivePointDerivativeComponent";
import FixedPointComponent from "./FixedPointComponent";
import ImprovedEulerComponent from "./ImprovedEulerComponent";
import NewtonRaphsonComponent from "./NewtonRaphsonComponent";
import RegulaFalsiComponent from "./RegulaFalsiComponent";
import RichardsonComponent from "./RichardsonComponent";
import RungeKuttaComponent from "./RungeKuttaComponent";
import RungeKuttaNystromComponent from "./RungeKuttaNystromComponent";
import SimpsonComponent from "./SimpsonComponent";
import SubmitButton from "./SubmitButton";
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
  const referenceToChild = useRef(null);

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
        console.log(response.data.problemString);
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

  const handleSumbission = () => {
    referenceToChild.current.submitData();
  };

  console.log(problemType);
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
          ref={referenceToChild}
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
          ref={referenceToChild}
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
          ref={referenceToChild}
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
          ref={referenceToChild}
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
          ref={referenceToChild}
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
          ref={referenceToChild}
        ></TrapezodialRuleComponent>
      );
    } else if (problemType === "Simpson") {
      return (
        <SimpsonComponent
          isSolved={isSolved}
          problemString={problemString}
          problemMethod={problemMethod}
          problemCategory={problemCategory}
          onProblemSolved={handleProblemSolved}
          onResultReceived={handleResultReceived}
          ref={referenceToChild}
        ></SimpsonComponent>
      );
    } else if (problemType === "Three-Point-Derivative") {
      return (
        <ThreePointDerivativeComponent
          isSolved={isSolved}
          problemString={problemString}
          problemMethod={problemMethod}
          problemCategory={problemCategory}
          onProblemSolved={handleProblemSolved}
          onResultReceived={handleResultReceived}
          ref={referenceToChild}
        ></ThreePointDerivativeComponent>
      );
    } else if (problemType === "Five-Point-Derivative") {
      return (
        <FivePointDerivativeComponent
          isSolved={isSolved}
          problemString={problemString}
          problemMethod={problemMethod}
          problemCategory={problemCategory}
          onProblemSolved={handleProblemSolved}
          onResultReceived={handleResultReceived}
          ref={referenceToChild}
        ></FivePointDerivativeComponent>
      );
    } else if (problemType === "Richardson") {
      return (
        <RichardsonComponent
          isSolved={isSolved}
          problemString={problemString}
          problemMethod={problemMethod}
          problemCategory={problemCategory}
          onProblemSolved={handleProblemSolved}
          onResultReceived={handleResultReceived}
          ref={referenceToChild}
        ></RichardsonComponent>
      );
    } else if (problemType === "Runge-Kutta") {
      return (
        <RungeKuttaComponent
          isSolved={isSolved}
          problemString={problemString}
          problemMethod={problemMethod}
          problemCategory={problemCategory}
          onProblemSolved={handleProblemSolved}
          onResultReceived={handleResultReceived}
          ref={referenceToChild}
        ></RungeKuttaComponent>
      );
    } else if (problemType === "Runge-Kutta-Nystrom") {
      return (
        <RungeKuttaNystromComponent
          isSolved={isSolved}
          problemString={problemString}
          problemMethod={problemMethod}
          problemCategory={problemCategory}
          onProblemSolved={handleProblemSolved}
          onResultReceived={handleResultReceived}
          ref={referenceToChild}
        ></RungeKuttaNystromComponent>
      );
    } else if (problemType === "Improved-Euler") {
      return (
        <ImprovedEulerComponent
          isSolved={isSolved}
          problemString={problemString}
          problemMethod={problemMethod}
          problemCategory={problemCategory}
          onProblemSolved={handleProblemSolved}
          onResultReceived={handleResultReceived}
          ref={referenceToChild}
        ></ImprovedEulerComponent>
      );
    } else if (problemType === "Direct-Euler") {
      return (
        <DirectEulerComponent
          isSolved={isSolved}
          problemString={problemString}
          problemMethod={problemMethod}
          problemCategory={problemCategory}
          onProblemSolved={handleProblemSolved}
          onResultReceived={handleResultReceived}
          ref={referenceToChild}
        ></DirectEulerComponent>
      );
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

  const mathRef = useRef(null);
  useEffect(() => {
    katex.render(problemString, mathRef.current, {
      throwOnError: false,
    });
  }, [problemString]);

  return (
    <>
      <div className="checkmark-pure">
        {isSolved || showCheckmark === true ? (
          <div className="checkmark">
            <img src={img} className="check-icon"></img>
            <p className="solvedTextForCheckmark">Solved</p>
          </div>
        ) : (
          <div></div>
        )}
      </div>
      <div>
        <div className="topRow">
          <div className="problemTitleAndNumber">
            {problemNumber}. {problemTitle}
          </div>
          <SubmitButton
            isButtonDisabled={isSolved}
            onClick={handleSumbission}
            className="submitButton"
          ></SubmitButton>
        </div>
        <div className="problemDifficultyDiv">
          <ProblemDifficulty difficulty={problemDifficulty}></ProblemDifficulty>
        </div>
        <div className="problemMethodDiv">{problemMethod}</div>

        <div className="problemDescriptionDiv">{problemDescription}</div>
        <div ref={mathRef} className="problemStringDiv"></div>
      </div>
      <div className="problemRender">{renderProblem(problemType)}</div>
      <div className="problemTags">
        <img src={img2} className="problemTagsImage"></img>
        Tags:
        <div className="problemTagCategory">{problemCategory}</div>
        <div className="problemTagType">{problemType}</div>
      </div>
    </>
  );
};
export default ProblemDescription;
