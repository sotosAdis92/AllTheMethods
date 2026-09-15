import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblemsByProblemType } from "../../services/ProblemService";
import ProblemDifficulty from "../ProblemDifficulty/ProblemDifficulty";
import "./ProblemTypePage.css";
const ProblemTypePage = () => {
  const [problems, setProblems] = useState([]);
  const { type } = useParams();
  console.log(type);
  useEffect(() => {
    getProblemsByProblemType(type)
      .then((response) => {
        setProblems(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const listOfProblems = problems.map((problem) => (
    <div key={problem.id}>
      <div>
        {problem.number}. {problem.title}
      </div>
      <ProblemDifficulty difficulty={problem.difficulty}></ProblemDifficulty>
      <div>{problem.points} pts</div>
    </div>
  ));

  return (
    <div>
      <div className="typeTitle">
        <img></img>
        <h2 className="text">{type}</h2>
      </div>
      <div className="problemsList">{listOfProblems}</div>
    </div>
  );
};
export default ProblemTypePage;
