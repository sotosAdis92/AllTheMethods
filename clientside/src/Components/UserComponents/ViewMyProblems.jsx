import { useEffect, useState } from "react";
import { getUserProblems } from "../../services/UserProblemService";
const ViewMyProblems = () => {
  const [myProblems, setMyProblems] = useState([]);
  const count = myProblems.filter((myPorblem) => myPorblem.problemId).length;

  const getAllUserProblems = () => {
    getUserProblems()
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
      {count >= 0 ? (
        <>
          <h1 className="userProblemsHeader">Solved Problems</h1>
          <ol>{listOfMyProblems}</ol>
        </>
      ) : (
        <h1>No Problems Solved Yet!!</h1>
      )}
    </>
  );
};

export default ViewMyProblems;
