import { useEffect, useState } from "react";
import { listProblems } from "../services/ProblemService";
import ProblemDifficulty from "./ProblemDifficulty";
const ListProblems = () => {
  const [problems, setProblems] = useState([]);
  useEffect(() => {
    listProblems()
      .then((response) => {
        setProblems(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  const listOfProblems = problems.map((problem) => (
    <div
      key={problem.id}
      className={problem.id % 2 === 0 ? "problemOdd" : "problemItem"}
    >
      <a href="/" className="problemLink">
        <div className="problemDetails">
          {problem.number}.{problem.title}
          <ProblemDifficulty
            difficulty={problem.difficulty}
          ></ProblemDifficulty>
        </div>
      </a>
    </div>
  ));
  return <ol>{listOfProblems}</ol>;
};
export default ListProblems;
