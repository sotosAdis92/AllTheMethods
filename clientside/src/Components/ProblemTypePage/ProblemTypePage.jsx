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
    <div key={problem.id} className="problemWithButtons">
      <div>
        {problem.number}. {problem.title}
      </div>
      <ProblemDifficulty difficulty={problem.difficulty}></ProblemDifficulty>
      <div>{problem.points} pts</div>
    </div>
  ));

  return (
    <div>
      <div className="viewTypes">
        <div className="typeTitle">
          <div className="imageContainer">
            <img className="typeImage"></img>
          </div>
          <div className="text">{type}</div>
        </div>
        <div className="subtitleText">AllTheMethods · count · favorites</div>
        <div className="progress">Progress</div>
      </div>
      <div className="problemsList">{listOfProblems}</div>
    </div>
  );
};
export default ProblemTypePage;
