import { useEffect, useState } from "react";
import "../../App.css";
import img2 from "../../assets/problem.png";
import { getProblemsCount } from "../../services/ProblemService";
import { getUserProblems } from "../../services/UserProblemService";
import ProblemDifficulty from "../ProblemDifficulty";
import "./ViewMyProblems.css";
const ViewMyProblems = (props) => {
  const [myProblems, setMyProblems] = useState([]);
  const count = myProblems.filter((myPorblem) => myPorblem.problemId).length;
  const [countOfAllProblems, setCountOfAllProblems] = useState("");
  const userId = props.userId;
  console.log(userId);
  const getAllUserProblems = () => {
    getUserProblems(userId)
      .then((response) => {
        setMyProblems(response.data);
        console.log("Api response:", response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  useEffect(() => {
    if (userId) {
      getAllUserProblems();
    }
  }, [userId]);

  useEffect(() => {
    getProblemsCount()
      .then((response) => {
        setCountOfAllProblems(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const listOfMyProblems = myProblems.map((myProblem) => (
    <div key={myProblem.problemId} className="userProblem">
      <div>{myProblem.title}</div>
      <div>{myProblem.category}</div>
      <div>
        <ProblemDifficulty
          difficulty={myProblem.difficulty}
        ></ProblemDifficulty>
      </div>
    </div>
  ));
  return (
    <>
      {count > 0 ? (
        <>
          <div className="problemsContainer">
            <div className="imageAndText">
              <div className="plainText">
                <h1 className="userProblemsHeader">Solved Problems</h1>
                <div className="userProblemsCounter">
                  Problems solved: {count}/{countOfAllProblems}
                </div>
              </div>
            </div>
            <ol className="listOfUserProblems">{listOfMyProblems}</ol>
          </div>
        </>
      ) : (
        <>
          <h1 className="userProblemsHeader">Solved Problems</h1>
          <div className="userProblemsCounter">{count} Problems solved</div>
          <img src={img2} className="countZeroImage"></img>
          <p className="noProblems">No Problems Solved Yet!!</p>
        </>
      )}
    </>
  );
};

export default ViewMyProblems;
