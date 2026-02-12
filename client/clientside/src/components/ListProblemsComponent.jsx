import { useEffect, useState } from "react";
import "../App.css";
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
      <div className="number">{problem.number}</div>
      <div className="title">{problem.title}</div>
      <div className="difficulty">{problem.difficulty}</div>
    </li>
  ));
  return (
    <div>
      <ol>{listOfProblems}</ol>
    </div>
  );
};

export default ListProblemComponent;
