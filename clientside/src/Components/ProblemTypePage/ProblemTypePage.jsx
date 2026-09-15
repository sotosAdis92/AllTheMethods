import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { getProblemsByProblemType } from "../../services/ProblemService";
import ProblemDifficulty from "../ProblemDifficulty/ProblemDifficulty";
import "./ProblemTypePage.css";
const ProblemTypePage = () => {
  const [problems, setProblems] = useState([]);
  const { type } = useParams();
  const navigate = useNavigate();
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

  const listOfProblems = problems.map((problem, i) => (
    <div className="problemWithButtons" key={problem.id}>
      <div
        className={i % 2 !== 0 ? "problemOdd" : "problemItem"}
        onClick={() => navigate("/problems/" + problem.id)}
      >
        <a className="problemLink">
          <div className="problemDetails">
            <div className="numberAndTitle">
              {problem.number}. {problem.title}
            </div>
            <ProblemDifficulty
              difficulty={problem.difficulty}
            ></ProblemDifficulty>
            <div className="pointsOfProblem">{problem.points}pts.</div>
          </div>
        </a>
      </div>
      <div></div>
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
        <hr className="line"></hr>
        <div className="progress">Progress</div>
      </div>
      <div className="problemsList">{listOfProblems}</div>
    </div>
  );
};
export default ProblemTypePage;
