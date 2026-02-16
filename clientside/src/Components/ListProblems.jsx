import { faPencil, faTrashCan } from "@fortawesome/free-solid-svg-icons";
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
      })
      .catch((error) => {
        console.error(error);
      });
  }
  useEffect(() => {
    getAllProblems();
  }, []);

  const listOfProblems = problems.map((problem, i) => (
    <div className="problemWithButtons">
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
      <Button variant="contained" onClick={() => updateProblem(problem.id)}>
        Update
        <FontAwesomeIcon icon={faPencil}></FontAwesomeIcon>
      </Button>
      <Button variant="contained" onClick={() => removeProblem(problem.id)}>
        Delete
        <FontAwesomeIcon icon={faTrashCan}></FontAwesomeIcon>
      </Button>
    </div>
  ));
  function addNewProblem() {
    navigator("/addProblem");
  }
  function updateProblem(id) {
    navigator(`/editProblem/${id}`);
  }
  function removeProblem(id) {
    console.log(id);
    deleteProblem(id)
      .then((response) => {
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
          Add New Problem +
        </Button>
      </Tooltip>
      <ol>{listOfProblems}</ol>
    </>
  );
};
export default ListProblems;
