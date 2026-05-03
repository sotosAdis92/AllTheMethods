import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import img from "../../assets/check.png";
import { getProblem } from "../../services/ProblemService";
import { getUserProblemById } from "../../services/UserProblemService";
import BisectionComponent from "./BisectionComponent";
import NewtonRaphsonComponent from "./NewtonRaphsonComponent";
import RegulaFalsiComponent from "./RegulaFalsiComponent";
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
  console.log(id);
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

  const renderProblem = (problemType) => {
    if (problemType === "Bisection") {
      return (
        <BisectionComponent
          isSolved={isSolved}
          problemString={problemString}
          problemMethod={problemMethod}
          problemCategory={problemCategory}
        ></BisectionComponent>
      );
    } else if (problemType === "Regula Falsi") {
      return <RegulaFalsiComponent isSolved={isSolved}></RegulaFalsiComponent>;
    } else if (problemType === "Newton Raphson") {
      return (
        <NewtonRaphsonComponent isSolved={isSolved}></NewtonRaphsonComponent>
      );
    } else if (problemType === "Diakriti Newton Raphson") {
      return (
        <DiakritiNewtonRaphsonComponent
          isSolved={isSolved}
        ></DiakritiNewtonRaphsonComponent>
      );
    } else if (problemType === "Fixed Point") {
      return <FixedPointComponent isSolved={isSolved}></FixedPointComponent>;
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
  });

  return (
    <>
      <div>
        {problemNumber}
        {problemTitle}
        {problemDifficulty}
        {problemDescription}
        {problemString}
        {problemMethod}
      </div>
      <div>
        {isSolved ? (
          <div className="checkmark">
            <p>Solved</p>
            <img src={img}></img>
          </div>
        ) : (
          <div></div>
        )}
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
