import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../../services/ProblemService";
import BisectionComponent from "./BisectionComponent";
const ProblemDescription = () => {
  const { id } = useParams();
  const [problemType, setProblemType] = useState("");
  useEffect(() => {
    getProblem(id)
      .then((response) => {
        setProblemType(response.data.problemType);
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
      <div>{renderProblem(problemType)}</div>
    </>
  );
};
export default ProblemDescription;
