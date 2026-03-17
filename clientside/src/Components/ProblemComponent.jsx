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
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import {
  createProblem,
  getProblem,
  updateProblem,
} from "../services/ProblemService";
const ProblemComponent = () => {
  const [number, setNumber] = useState(0);
  const [title, setTitle] = useState("");
  const [category, setCategory] = useState("");
  const [difficulty, setDifficulty] = useState("");
  const [description, setDescription] = useState("");
  const [functionString, SetfunctionString] = useState("");
  const [points, setPoints] = useState(0);
  const navigator = useNavigate();
  const [errors, setErrors] = useState({
    number: "",
    title: "",
    category: "",
    difficulty: "",
    description: "",
    points: "",
    function: functionString,
  });
  const { id } = useParams();

  useEffect(() => {
    if (id) {
      getProblem(id).then((response) => {
        setNumber(response.data.number);
        setTitle(response.data.title);
        setCategory(response.data.category);
        setDifficulty(response.data.difficulty);
        setDescription(response.data.description);
        setPoints(response.data.points);
        SetfunctionString(response.data.function);
      });
    }
  }, [id]);

  function pageTitle() {
    if (id) {
      return <h2>Edit Problem</h2>;
    } else {
      return <h2>Add Problem</h2>;
    }
  }

  const increment = () => {
    setNumber((n) => n + 1);
  };
  const decrement = () => {
    setNumber((n) => n - 1);
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
    setPoints((p) => p + 5);
  };
  const decreasePoints = () => {
    setPoints((p) => p - 5);
  };
  const handleDescription = (e) => {
    setDescription(e.target.value);
  };

  const handleFunctionString = (e) => {
    SetfunctionString(e.target.value);
  };
  const saveOrUpdateProblem = (e) => {
    e.preventDefault();
    if (validateForm()) {
      const problem = {
        number,
        title,
        category,
        difficulty,
        description,
        points,
        function: functionString,
      };
      if (id) {
        updateProblem(id, problem)
          .then((response) => {
            console.log(response.data);
            navigator("/problems");
          })
          .catch((error) => {
            console.error(error);
          });
      } else {
        console.log(problem);
        createProblem(problem)
          .then((response) => {
            console.log(response.data);
            navigator("/problems");
          })
          .catch((error) => {
            console.error(error);
          });
      }
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

    if (functionString.trim()) {
      errorsCopy.functions = "";
    } else {
      errorsCopy.functions = "Error, Function cannot be null";
      valid = false;
    }
    setErrors(errorsCopy);
    return valid;
  }
  return (
    <div>
      {pageTitle()}
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

        <div className="row">
          <TextField
            type="text"
            placeholder="Enter Problem Function"
            name="functions"
            value={functionString}
            id={"outlined"}
            error={errors.functions}
            helperText={errors.functions}
            onChange={handleFunctionString}
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
        <Button
          variant="contained"
          color="success"
          onClick={saveOrUpdateProblem}
        >
          Submit
          <FontAwesomeIcon icon={faCheck}></FontAwesomeIcon>
        </Button>
        <Button variant="contained" color="error">
          Cancel
          <FontAwesomeIcon icon={faX}></FontAwesomeIcon>
        </Button>
      </div>
    </div>
  );
};
export default ProblemComponent;
