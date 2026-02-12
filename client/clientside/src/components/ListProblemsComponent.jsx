import { useEffect, useState } from "react";
import "../App.css";
import { listProblems } from "../services/ProblemService";
import DifficultyComponent from "./DifficultyComponent";

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
    <a
      className="problemLink"
      href={"/problems/" + problem.title.replace(/\s+/g, "")}
      key={problem.id}
    >
      <div className="number">{problem.number}.</div>
      <div className="title">{problem.title}</div>
      <DifficultyComponent
        difficulty={problem.difficulty}
      ></DifficultyComponent>
    </a>
  ));
  return (
    <div>
      <ol className="problems">{listOfProblems}</ol>
    </div>
  );
};

export default ListProblemComponent;
