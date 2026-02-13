import { useEffect, useState } from "react";
import { listProblems } from "../services/ProblemService";

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
    <div key={problem.id}>
      <a>
        <div>
          {problem.number}
          {problem.title}
          {problem.difficulty}
        </div>
      </a>
    </div>
  ));
  return <ol>{listOfProblems}</ol>;
};
export default ListProblems;
