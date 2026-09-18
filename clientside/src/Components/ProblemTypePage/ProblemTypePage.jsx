import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { useAuth } from "../../context/AuthContext";
import { getProblemsByProblemType } from "../../services/ProblemService";
import { getUserProblemBySolvedType } from "../../services/UserProblemService";
import ProblemDifficulty from "../ProblemDifficulty/ProblemDifficulty";
import "./ProblemTypePage.css";
const ProblemTypePage = () => {
  const [problems, setProblems] = useState([]);
  const [countDistinct, setCountDistinct] = useState([]);
  const { type } = useParams();
  const { user } = useAuth();
  const userId = user?.id;
  console.log(userId);
  const navigate = useNavigate();

  useEffect(() => {
    getProblemsByProblemType(type)
      .then((response) => {
        setProblems(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  useEffect(() => {
    if (userId) {
      getUserProblemBySolvedType(userId, type)
        .then((response) => {
          console.log(response.data);
          setCountDistinct([response.data]);
        })
        .catch((error) => {
          console.log(error);
        });
    }
  }, [userId, type]);

  const listOfUserData = countDistinct.map((item, i) => {
    return (
      <div key={i} className="containerTypesSolved">
        <ProblemDifficulty
          difficulty={item.difficulty}
          className="problemDifficultyTypes"
        ></ProblemDifficulty>
        <div className="numbersTypes">
          {item.countDistinct}/{item.countDifficulty}
        </div>
      </div>
    );
  });

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
    <div className="typesProblemsPageContainer">
      <div className="viewTypes">
        <div className="typeTitle">
          <div className="imageContainer">
            <img className="typeImage"></img>
          </div>
          <div className="text">{type}</div>
        </div>
        <div className="subtitleText">AllTheMethods · {problems.length}</div>
        <hr className="line"></hr>
        <div className="progressText">Progress</div>
        <div className="listOfUserDataTypes">{listOfUserData}</div>
      </div>
      <div className="problemsList">{listOfProblems}</div>
    </div>
  );
};
export default ProblemTypePage;
