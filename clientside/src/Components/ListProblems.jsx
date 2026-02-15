import Button from "@mui/material/Button";
import Tooltip from "@mui/material/Tooltip";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { listProblems } from "../services/ProblemService";
import ProblemDifficulty from "./ProblemDifficulty";

const ListProblems = () => {
  const [problems, setProblems] = useState([]);
  const navigator = useNavigate();
  useEffect(() => {
    listProblems()
      .then((response) => {
        setProblems(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  const listOfProblems = problems.map((problem, i) => (
    <div
      key={problem.id}
      className={i % 2 !== 0 ? "problemOdd" : "problemItem"}
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
  function addNewProblem() {
    navigator("/addProblem");
  }

  return (
    <>
      <h2 className="problemsTitle">List Of Problems</h2>
      <Tooltip title="Add" placement="top" arrow>
        <Button variant="contained" onClick={addNewProblem}>
          Add New Problem +
        </Button>
      </Tooltip>
      <ol>{listOfProblems}</ol>
    </>
  );
};
export default ListProblems;
