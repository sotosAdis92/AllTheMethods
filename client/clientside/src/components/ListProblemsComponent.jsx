import { useEffect, useState } from "react";
import { listProblems } from "../services/ProblemService";
const ListProblemComponent = () => {
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
    <li key={problem.id}>
      {problem.number}
      {problem.title}
      {problem.difficulty}
    </li>
  ));
  return (
    <div>
      <ol>{listOfProblems}</ol>
    </div>
  );
};

export default ListProblemComponent;
