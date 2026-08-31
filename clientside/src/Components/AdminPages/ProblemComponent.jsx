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
} from "../../services/ProblemService";
import "./ProblemComponent.css";
const ProblemComponent = () => {
  const [number, setNumber] = useState(0);
  const [title, setTitle] = useState("");
  const [category, setCategory] = useState("");
  const [difficulty, setDifficulty] = useState("");
  const [description, setDescription] = useState("");
  const [problemString, setProblemString] = useState("");
  const [problemType, setProblemType] = useState("");
  const [functionString, setFunctionString] = useState("");
  const [problemData, setProblemData] = useState("");
  const [points, setPoints] = useState(0);
  const navigator = useNavigate();
  const [errors, setErrors] = useState({
    number: "",
    title: "",
    category: "",
    difficulty: "",
    description: "",
    points: "",
    problemString: "",
    problemType: "",
    functionString: "",
    problemData: "",
  });
  const { id } = useParams();
  console.log(id);
  useEffect(() => {
    if (id) {
      getProblem(id).then((response) => {
        console.log("Fetched problem data:", response.data);
        setNumber(response.data.number);
        setTitle(response.data.title);
        setCategory(response.data.category);
        setDifficulty(response.data.difficulty);
        setDescription(response.data.description);
        setPoints(response.data.points);
        setProblemString(response.data.problemString);
        setProblemType(response.data.problemType);
        setFunctionString(response.data.functionString);
        setProblemData(response.data.problemData);
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
    if (number > 0) {
      setNumber((n) => (n > 0 ? n - 1 : n));
    }
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
    if (points > 0) {
      setPoints((p) => p - 5);
    }
  };
  const handleDescription = (e) => {
    setDescription(e.target.value);
  };
  const handleProblemType = (e) => {
    setProblemType(e.target.value);
  };
  const handleFunctionString = (e) => {
    setFunctionString(e.target.value);
  };
  const handleProblemData = (e) => {
    setProblemData(e.target.value);
  };

  const handleProblemString = (e) => {
    console.log("1. Input changed to:", e.target.value);
    setProblemString(e.target.value);
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
        problemString,
        problemType,
        functionString,
        problemData,
      };
      console.log("3. Sending problem object:", problem);
      if (id) {
        updateProblem(id, problem)
          .then((response) => {
            console.log(response.data);
            navigator("/admin");
          })
          .catch((error) => {
            console.error(error);
          });
      } else {
        console.log(problem);
        createProblem(problem)
          .then((response) => {
            console.log(response.data);
            navigator("/admin");
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

    if (problemString.trim()) {
      errorsCopy.problemString = "";
    } else {
      errorsCopy.problemString = "Error, the problem cannot be empty";
      valid = false;
    }

    if (problemType.trim()) {
      errorsCopy.problemType = "";
    } else {
      errorsCopy.problemType = "Error, the problem type cannot be empty";
      valid = false;
    }

    if (functionString.trim()) {
      errorsCopy.functionString = "";
    } else {
      errorsCopy.functionString = "Error, the function string cannot be empty";
      valid = false;
    }

    if (problemData.trim()) {
      errorsCopy.problemData = "";
    } else {
      errorsCopy.problemData = "Error, the problem data cannot be empty";
      valid = false;
    }

    setErrors(errorsCopy);
    return valid;
  }
  return (
    <div className="problem-container">
      {pageTitle()}
      <div className="card">
        <div className="row">
          <h4>Problem Number</h4>
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
            placeholder="Enter Problem"
            name="problemString"
            value={problemString}
            id={"outlined"}
            error={errors.problemString}
            helperText={errors.problemString}
            onChange={handleProblemString}
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
          <h4>Problem Points</h4>
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
            error={errors.description}
            helperText={errors.description}
          ></TextField>
        </div>

        <div className="row">
          <TextField
            type="text"
            placeholder="Enter Problem Type"
            name="type"
            value={problemType}
            onChange={handleProblemType}
            id={"outlined"}
            error={errors.problemType}
            helperText={errors.problemType}
          ></TextField>
        </div>
        <div className="row">
          <TextField
            type="text"
            placeholder="Enter Function String"
            name="functionString"
            value={functionString}
            onChange={handleFunctionString}
            id={"outlined"}
            error={errors.functionString}
            helperText={errors.functionString}
          ></TextField>
        </div>
        <div className="row">
          <TextField
            type="text"
            placeholder="Enter Problem Data"
            name="problemData"
            value={problemData}
            onChange={handleProblemData}
            id={"outlined"}
            error={errors.problemData}
            helperText={errors.problemData}
          ></TextField>
        </div>
        <div className="buttonsDiv">
          <Button
            variant="contained"
            color="success"
            onClick={saveOrUpdateProblem}
          >
            Submit
            <FontAwesomeIcon icon={faCheck}></FontAwesomeIcon>
          </Button>
          <Button
            variant="contained"
            color="error"
            onClick={() => navigator("/admin")}
          >
            Cancel
            <FontAwesomeIcon icon={faX}></FontAwesomeIcon>
          </Button>
        </div>
      </div>
    </div>
  );
};
export default ProblemComponent;
