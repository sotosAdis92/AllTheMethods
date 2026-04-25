import {
  faPencil,
  faPlus,
  faTrashCan,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import Button from "@mui/material/Button";
import Tooltip from "@mui/material/Tooltip";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { deleteProblem, listProblems } from "../services/ProblemService";
import ProblemDifficulty from "./ProblemDifficulty";

const ListProblems = () => {
  const [problems, setProblems] = useState([]);
  const navigator = useNavigate();
  function getAllProblems() {
    listProblems()
      .then((response) => {
        setProblems(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }
  useEffect(() => {
    getAllProblems();
  }, []);

  function navigate(problemId) {
    navigator("problems/" + problemId);
  }

  const listOfProblems = problems.map((problem, i) => (
    <div className="problemWithButtons">
      <div
        key={problem.problemId}
        className={i % 2 !== 0 ? "problemOdd" : "problemItem"}
        onClick={() => navigate(problem.problemId)}
      >
        <a className="problemLink">
          <div className="problemDetails">
            {problem.number}.{problem.title}
            <ProblemDifficulty
              difficulty={problem.difficulty}
            ></ProblemDifficulty>
            {problem.points}pts.
          </div>
        </a>
      </div>
      <Button
        variant="contained"
        onClick={() => updateProblem(problem.problemId)}
      >
        <FontAwesomeIcon icon={faPencil}></FontAwesomeIcon>
      </Button>
      <Button
        variant="contained"
        onClick={() => removeProblem(problem.problemId)}
      >
        <FontAwesomeIcon icon={faTrashCan}></FontAwesomeIcon>
      </Button>
    </div>
  ));
  function addNewProblem() {
    navigator("/addProblem");
  }
  function updateProblem(problemId) {
    navigator(`/editProblem/${problemId}`);
  }
  function removeProblem(problemId) {
    console.log(problemId);
    deleteProblem(problemId)
      .then(() => {
        getAllProblems();
      })
      .catch((error) => {
        console.error(error);
      });
  }

  return (
    <>
      <h2 className="problemsTitle">List Of Problems</h2>
      <Tooltip title="Add" placement="top" arrow>
        <Button variant="contained" onClick={addNewProblem}>
          <FontAwesomeIcon icon={faPlus}></FontAwesomeIcon>
        </Button>
      </Tooltip>
      <ol>{listOfProblems}</ol>
    </>
  );
};
export default ListProblems;
