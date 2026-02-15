import {
  faCheck,
  faMinus,
  faPlus,
  faX,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import Button from "@mui/material/Button";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { createProblem } from "../services/ProblemService";
const ProblemComponent = () => {
  const [number, setNumber] = useState(0);
  const [title, setTitle] = useState("");
  const [category, setCategory] = useState("");
  const [difficulty, setDifficulty] = useState("");
  const [description, setDescription] = useState("");
  const [points, setPoints] = useState(0);
  const navigator = useNavigate();
  const [errors, setErrors] = useState({
    number: 0,
    title: "",
    category: "",
    difficulty: "",
    description: "",
    points: 0,
  });

  const increment = () => {
    setNumber(number + 1);
  };
  const decrement = () => {
    setNumber(number - 1);
  };
  const handleTitle = (e) => {
    setTitle(e.target.value);
  };
  const getSelectedCategory = (e) => {
    setCategory(e.target.value);
  };
  const getSelectedDifficulty = (e) => {
    setDifficulty(e.target.value);
  };
  const increasePoints = () => {
    setPoints(points + 5);
  };
  const decreasePoints = () => {
    setPoints(points - 5);
  };
  const handleDescription = (e) => {
    setDescription(e.target.value);
  };
  const saveProblem = (e) => {
    e.preventDefault();
    if (validateForm) {
      const problem = {
        number,
        title,
        category,
        difficulty,
        description,
        points,
      };
      console.log(problem);
      createProblem(problem).then((response) => {
        console.log(response.data);
        navigator("/problems");
      });
    }
  };

  function validateForm() {
    let valid = true;
    const errorsCopy = { ...errors };
    if (number > 0) {
      errorsCopy.number = 0;
    } else {
      errorsCopy.number = "Error, Number cannot be negative";
      valid = false;
    }
    if (title.trim()) {
      errorsCopy.title = "";
    } else {
      errorsCopy.title = "Error, title cannot be empty";
      valid = false;
    }
    if (!category || category !== "Choose an option") {
      errorsCopy.category = "";
    } else {
      errorsCopy.category = "Error, category cannot be empty";
      valid = false;
    }
    if (!difficulty || difficulty !== "Choose an option") {
      errorsCopy.difficulty = "";
    } else {
      errorsCopy.difficulty = "Error, difficulty cannot be empty";
      valid = false;
    }
    if (description.trim()) {
      errorsCopy.description = "";
    } else {
      errorsCopy.description = "Error, description cannot be empty";
      valid = false;
    }
    if (points > 0) {
      errorsCopy.points = "";
    } else {
      errorsCopy.points = "Error, points cannot be negative";
      valid = false;
    }
    setErrors(errorsCopy);
    return valid;
  }
  return (
    <div className="card">
      <div className="row">
        <button className="changeNumber" onClick={increment}>
          <FontAwesomeIcon icon={faPlus}></FontAwesomeIcon>
        </button>
        <button className="changeNumber" onClick={decrement}>
          <FontAwesomeIcon icon={faMinus}></FontAwesomeIcon>
        </button>
        <p className="numberText">{number}</p>
      </div>
      <div className="row">
        <input
          type="text"
          placeholder="Enter Problem title"
          name="title"
          value={title}
          className={`form-control ${errors.title ? "is-invalid" : ""}`}
          onChange={handleTitle}
        ></input>
        {errors.title && (
          <div className="invalid-feedback"> {errors.title}</div>
        )}
      </div>
      <div className="selector">
        <select
          onChange={getSelectedCategory}
          value={category}
          class="form-select"
          id="validationCustom04"
        >
          <option>Choose an option</option>
          <option>Polynomial Roots</option>
          <option>Integrals</option>
          <option>Derivatives</option>
          <option>Linear Systems</option>
          <option>Paremboles</option>
          <option>Differential Equations</option>
        </select>
      </div>
      {errors.category && (
        <div className="invalid-feedback"> {errors.category}</div>
      )}
      <div className="selector">
        <select
          onChange={getSelectedDifficulty}
          value={difficulty}
          class="form-select"
          id="validationCustom04"
        >
          <option>Choose an option</option>
          <option>Easy</option>
          <option>Med.</option>
          <option>Hard</option>
        </select>
      </div>
      {errors.difficulty && (
        <div className="invalid-feedback"> {errors.difficulty}</div>
      )}
      <div className="row">
        <button className="changeNumber" onClick={increasePoints}>
          <FontAwesomeIcon icon={faPlus}></FontAwesomeIcon>
        </button>
        <button className="changeNumber" onClick={decreasePoints}>
          <FontAwesomeIcon icon={faMinus}></FontAwesomeIcon>
        </button>
        <p className="numberText">{points}</p>
      </div>
      <div className="row">
        <input
          type="text"
          placeholder="Enter Problem description"
          name="description"
          value={description}
          className={`form-control ${errors.description ? "is-invalid" : ""}`}
          onChange={handleDescription}
        ></input>
        {errors.description && (
          <div className="invalid-feedback"> {errors.description}</div>
        )}
      </div>
      <Button variant="contained" color="success" onClick={saveProblem}>
        Submit
        <FontAwesomeIcon icon={faCheck}></FontAwesomeIcon>
      </Button>
      <Button variant="contained" color="error">
        Cancel
        <FontAwesomeIcon icon={faX}></FontAwesomeIcon>
      </Button>
    </div>
  );
};
export default ProblemComponent;
