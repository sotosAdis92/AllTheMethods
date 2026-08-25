import {
  faPencil,
  faPlus,
  faTrashCan,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { deleteProblem, listProblems } from "../../services/ProblemService";
import "./ProblemListComponent.css";
const ProblemListComponent = () => {
  const navigator = useNavigate();
  const [problems, setProblems] = useState([]);

  useEffect(() => {
    listProblems().then((response) => {
      console.log(response.data);
      setProblems(response.data);
    });
  }, []);

  const deleteProblemFunc = (problemId) => {
    deleteProblem(problemId).then(() => {
      listProblems().then((response) => {
        setProblems(response.data);
      });
    });
  };

  const editProblem = (problemId) => {
    navigator(`/admin/problems/update/${problemId}`);
  };

  const addProblem = () => {
    navigator("/admin/problems/add");
  };

  const listOfProblems = problems.map((problem) => (
    <div key={problem.id} className="problem-item-table">
      <div>{problem.id}</div>
      <div>{problem.title}</div>
      <div>{problem.number}</div>
      <div>{problem.category}</div>
      <div>{problem.difficulty}</div>
      <div>{problem.functionString}</div>
      <div>{problem.points}</div>
      <div>{problem.problemData}</div>
      <div>{problem.problemType}</div>
      <div>
        <button
          className="edit-btn-table"
          onClick={() => editProblem(problem.id)}
        >
          <FontAwesomeIcon icon={faPencil} />
        </button>
        <button
          className="delete-btn-table"
          onClick={() => deleteProblemFunc(problem.id)}
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
      <div>
        <div className="headerProblem problem-item-table">
          <div>Id</div>
          <div>Title</div>
          <div>Number</div>
          <div>Category</div>
          <div>Difficulty</div>
          <div></div>
          <div>Points</div>
          <div>Problem Data</div>
          <div>Problem Type</div>
        </div>
        {listOfProblems}
      </div>
    </div>
  );
};
export default ProblemListComponent;
