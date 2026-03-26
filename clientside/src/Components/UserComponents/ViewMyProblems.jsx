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

  const listOfMyProblems = myProblems.map((myPorblem) => (
    <div key={myPorblem.problemId}>
      <div>{myPorblem.title}</div>
      <div>{}</div>
    </div>
  ));
  return (
    <>
      {count >= 0 ? (
        <>
          <h1>Solved Problems</h1>
          <ol>{listOfMyProblems}</ol>{" "}
        </>
      ) : (
        <h1>No Problems Solved</h1>
      )}
    </>
  );
};

export default ViewMyProblems;
