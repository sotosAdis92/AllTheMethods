import {
  faCheck,
  faMinus,
  faPlus,
  faX,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { TextField } from "@mui/material";
import Button from "@mui/material/Button";
import FormControl from "@mui/material/FormControl";
import FormHelperText from "@mui/material/FormHelperText";
import InputLabel from "@mui/material/InputLabel";
import MenuItem from "@mui/material/MenuItem";
import Select from "@mui/material/Select";
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
    number: "",
    title: "",
    category: "",
    difficulty: "",
    description: "",
    points: "",
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
    if (validateForm()) {
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
      errorsCopy.number = "";
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
    if (category && category.trim() !== "") {
      errorsCopy.category = "";
    } else {
      errorsCopy.category = "Error, category cannot be empty";
      valid = false;
    }
    if (difficulty && difficulty.trim() !== "") {
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
        <Button type="button" variant="contained" onClick={increment}>
          <FontAwesomeIcon icon={faPlus}></FontAwesomeIcon>
        </Button>
        <Button type="button" variant="contained" onClick={decrement}>
          <FontAwesomeIcon icon={faMinus}></FontAwesomeIcon>
        </Button>
        <p className="numberText">{number}</p>
        {errors.number && <FormHelperText> {errors.number}</FormHelperText>}
      </div>
      <div className="row">
        <TextField
          type="text"
          placeholder="Enter Problem title"
          name="title"
          value={title}
          id={"outlined"}
          error={errors.title}
          helperText={errors.title}
          onChange={handleTitle}
        ></TextField>
      </div>
      <div className="selector">
        <FormControl error={errors.category} sx={{ minWidth: 210 }}>
          <InputLabel>Category</InputLabel>
          <Select
            onChange={getSelectedCategory}
            value={category}
            label="Category"
          >
            <MenuItem value={"Polynomial Roots"}>Polynomial Roots</MenuItem>
            <MenuItem value={"Integrals"}>Integrals</MenuItem>
            <MenuItem value={"Paremboles"}>Paremboles</MenuItem>
            <MenuItem value={"Linear Systems"}>Linear Systems</MenuItem>
            <MenuItem value={"Derivatives"}>Derivatives</MenuItem>
            <MenuItem value={"Differential Equations"}>
              Differential Equations
            </MenuItem>
          </Select>
          {errors.category && (
            <FormHelperText>{errors.category}</FormHelperText>
          )}
        </FormControl>
      </div>
      <div className="selector">
        <FormControl error={errors.difficulty} sx={{ minWidth: 210 }}>
          <InputLabel>Difficulty</InputLabel>
          <Select
            onChange={getSelectedDifficulty}
            value={difficulty}
            label="difficulty"
          >
            <MenuItem value={"Easy"}>Easy</MenuItem>
            <MenuItem value={"Med."}>Med.</MenuItem>
            <MenuItem value={"Hard"}>Hard</MenuItem>
          </Select>
          {errors.difficulty && (
            <FormHelperText> {errors.difficulty}</FormHelperText>
          )}
        </FormControl>
      </div>
      <div className="row">
        <Button type="button" variant="contained" onClick={increasePoints}>
          <FontAwesomeIcon icon={faPlus}></FontAwesomeIcon>
        </Button>
        <Button type="button" variant="contained" onClick={decreasePoints}>
          <FontAwesomeIcon icon={faMinus}></FontAwesomeIcon>
        </Button>
        <p className="numberText">{points}</p>
        {errors.points && <FormHelperText> {errors.points}</FormHelperText>}
      </div>
      <div className="row">
        <TextField
          type="text"
          placeholder="Enter Problem description"
          name="description"
          value={description}
          onChange={handleDescription}
          id={"outlined"}
          error={errors.title}
          helperText={errors.title}
        ></TextField>
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
