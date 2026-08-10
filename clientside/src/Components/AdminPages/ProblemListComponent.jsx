import {
  faPencil,
  faPlus,
  faTrashCan,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { listProblems } from "../../services/ProblemService";
const ProblemListComponent = () => {
  const navigator = useNavigate();
  const [problems, setProblems] = useState([]);

  useEffect(() => {
    listProblems().then((response) => {
      console.log(response.data);
      setProblems(response.data);
    });
  }, []);

  const deleteProblem = (problemId) => {
    deleteProblem(problemId);
  };

  const editProblem = (problemId) => {
    navigator(`/admin/problems/update/${problemId}`);
  };

  const addProblem = () => {
    navigator("/admin/problems/add");
  };

  const listOfProblems = problems.map((problem) => (
    <div key={problem.id} className="achievement-item-table">
      <div>{problem.id}</div>
      <div>{problem.title}</div>
      <div>
        <button
          className="edit-btn-table"
          onClick={() => editProblem(problem.id)}
        >
          <FontAwesomeIcon icon={faPencil} />
        </button>
        <button
          className="delete-btn-table"
          onClick={() => deleteProblem(problem.id)}
        >
          <FontAwesomeIcon icon={faTrashCan} />
        </button>
      </div>
    </div>
  ));

  return (
    <div>
      <div>
        <button className="add-btn-table" onClick={() => addProblem()}>
          <FontAwesomeIcon icon={faPlus} />
        </button>
      </div>
      <div>{listOfProblems}</div>
    </div>
  );
};
export default ProblemListComponent;
