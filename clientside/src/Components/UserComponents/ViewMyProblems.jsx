import { useEffect, useState } from "react";
import { getUserProblems } from "../../services/UserProblemService";

import img2 from "../../assets/problem.png";
const ViewMyProblems = (props) => {
  const [myProblems, setMyProblems] = useState([]);
  const count = myProblems.filter((myPorblem) => myPorblem.problemId).length;

  const getAllUserProblems = () => {
    getUserProblems(props.userId)
      .then((response) => {
        setMyProblems(response.data);
        console.log("Api response:", response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  useEffect(() => {
    getAllUserProblems();
  }, []);

  const listOfMyProblems = myProblems.map((myProblem) => (
    <div key={myProblem.problemId}>
      <div>{myProblem.title}</div>
      <div>{myProblem.category}</div>
      <div>{myProblem.difficulty}</div>
      <div>{myProblem.points}</div>
    </div>
  ));
  return (
    <>
      {count > 0 ? (
        <>
          <h1 className="userProblemsHeader">Solved Problems</h1>
          <div className="useProblemsCounter">{count} Problems solved</div>
          <ol>{listOfMyProblems}</ol>
        </>
      ) : (
        <>
          <h1 className="userProblemsHeader">Solved Problems</h1>
          <div className="userProblemsCounter">{count} Problems solved</div>
          <img src={img2}></img>
          <p className="noProblems">No Problems Solved Yet!!</p>
        </>
      )}
    </>
  );
};

export default ViewMyProblems;
