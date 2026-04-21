import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../../services/ProblemService";
import BisectionComponent from "./BisectionComponent";
const ProblemDescription = () => {
  const { id } = useParams();
  const [problemType, setProblemType] = useState("");

  const [problemTitle, setProblemTitle] = useState("");
  const [problemNumber, setProblemNumber] = useState("");
  const [problemDifficulty, setProblemDifficulty] = useState("");
  const [problemCategory, setProblemCategory] = useState("");
  useEffect(() => {
    getProblem(id)
      .then((response) => {
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
    if (problemType == "Bisection") {
      return <BisectionComponent></BisectionComponent>;
    }
  };

  return (
    <>
      <div>
        {problemNumber}
        {problemTitle}
        {problemDifficulty}
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
