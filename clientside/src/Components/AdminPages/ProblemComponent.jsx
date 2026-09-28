import {
  faCheck,
  faInfo,
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
import { useEffect, useRef, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import {
  createProblem,
  getProblem,
  updateProblem,
} from "../../services/ProblemService";
import "./ProblemComponent.css";
const ProblemComponent = () => {
  const buttonRefs = useRef({});
  const [number, setNumber] = useState(0);
  const [showGuide, setShowGuide] = useState(false);
  const [highlightedField, setHighlightedField] = useState(null);
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

  const openSideGuide = (field) => {
    setShowGuide((prev) => {
      const nextShowGuide = !prev;
      if (!nextShowGuide) {
        setHighlightedField(null);
      } else {
        setHighlightedField((prevField) =>
          prevField === field ? null : field,
        );
      }
      return nextShowGuide;
    });
  };

  const guideContent = {
    number: {
      title: "Adding a problem Number",
      body: "Adding a problem number means adding the number next to the problem title, and it is the first thing the user sees. An example of the problem number is 1. XYZW ... The Number should be an integer, positive and unique, no 2 problems should have the same number",
    },
    title: {
      title: "Adding a problem Title",
      body: "Adding a problem title means adding the text next to the number we previously added, An example is 'Bisection I', meaning the method name and the title number of the type, this is optional, it can be a very short description of what the problem has.",
    },
    problemString: {
      title: "Adding a problem String",
      body: "Adding a problem String means adding the problem as it is written in the exams, this will not be showing up on the UI, but it is helpful in the admin panel to know what latex is what string, write the function as it would be written normally, for example 'x^2 - 2'",
    },
    category: {
      title: "Adding a category",
      body: "Adding a category means picking from the dropdown menu the category the problem belongs to, try to pick the correct one",
    },
    difficulty: {
      title: "Adding a difficulty",
      body: "Adding a problem difficulty means choosing the appropriate difficulty for the problem you wish to be entered",
    },
    points: {
      title: "Adding points",
      body: "Adding problem points means giving a Easy problem 5pts, a Med. 10pts or a Hard one 20pts, no more than that",
    },
    description: {
      title: "Adding a description",
      body: "Adding the problem description is the most important part since it is the entire text that gives the user the whole problem and what constraints and asumpations they may take in solving it.",
    },
    problemType: {
      title: "Adding a problem Type",
      body: "Adding the problem type means giving the problem the category of the method it is in, for example 'Bisection'",
    },
    functionString: {
      title: "Adding a function String",
      body: "Adding a function String means adding the latex version of the exact same problem string added earlier, for example 'frac{d }{dx}x^2' with the slash in front",
    },
    problemData: {
      title: "Adding the problem data",
      body: `Adding the problem data means adding a json (stored as json in the database), of all the parameters that the problem needs to be solved, for example {"problemSpaceA": 1, "problemSpaceB": 3, "iterations": 3}, it needs to be valid json or else it wont work`,
    },
  };

  return (
    <div className="containerAddProblems">
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
            <FontAwesomeIcon
              icon={faInfo}
              className="info"
              onClick={() => openSideGuide("number")}
              ref={(el) => (buttonRefs.current["number"] = el)}
            ></FontAwesomeIcon>
          </div>
          <div className="row">
            <span className="rowText">
              Problem Title
              <FontAwesomeIcon
                icon={faInfo}
                className="info"
                onClick={() => openSideGuide("title")}
                ref={(el) => (buttonRefs.current["title"] = el)}
              ></FontAwesomeIcon>
            </span>
            <TextField
              type="text"
              placeholder="i.e: Bisection I"
              name="title"
              value={title}
              id={"outlined"}
              error={errors.title}
              helperText={errors.title}
              onChange={handleTitle}
            ></TextField>
          </div>
          <div className="row">
            <span className="rowText">
              Problem String
              <FontAwesomeIcon
                icon={faInfo}
                className="info"
                onClick={() => openSideGuide("problemString")}
                ref={(el) => (buttonRefs.current["problemString"] = el)}
              ></FontAwesomeIcon>
            </span>
            <TextField
              type="text"
              placeholder="i.e: x^2 - 2"
              name="problemString"
              value={problemString}
              id={"outlined"}
              error={errors.problemString}
              helperText={errors.problemString}
              onChange={handleProblemString}
            ></TextField>
          </div>
          <div className="row">
            <FontAwesomeIcon
              icon={faInfo}
              className="info"
              onClick={() => openSideGuide("category")}
              ref={(el) => (buttonRefs.current["category"] = el)}
            ></FontAwesomeIcon>
            <div className="selector">
              <FormControl error={errors.category} sx={{ minWidth: 210 }}>
                <InputLabel>Category</InputLabel>
                <Select
                  onChange={getSelectedCategory}
                  value={category}
                  label="Category"
                >
                  <MenuItem value={"Polynomial Roots"}>
                    Polynomial Roots
                  </MenuItem>
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
          </div>

          <div className="row">
            <FontAwesomeIcon
              icon={faInfo}
              className="info"
              onClick={() => openSideGuide("difficulty")}
              ref={(el) => (buttonRefs.current["difficulty"] = el)}
            ></FontAwesomeIcon>
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
            <FontAwesomeIcon
              icon={faInfo}
              className="info"
              onClick={() => openSideGuide("points")}
              ref={(el) => (buttonRefs.current["points"] = el)}
            ></FontAwesomeIcon>
          </div>
          <div className="row">
            <span className="rowText">
              Problem Description
              <FontAwesomeIcon
                icon={faInfo}
                className="info"
                onClick={() => openSideGuide("description")}
                ref={(el) => (buttonRefs.current["description"] = el)}
              ></FontAwesomeIcon>
            </span>
            <TextField
              type="text"
              placeholder="Enter Problem description i.e: Given the following..."
              name="description"
              value={description}
              onChange={handleDescription}
              id={"outlined"}
              error={errors.description}
              helperText={errors.description}
            ></TextField>
          </div>

          <div className="row">
            <span className="rowText">
              Problem Type
              <FontAwesomeIcon
                icon={faInfo}
                className="info"
                onClick={() => openSideGuide("problemType")}
                ref={(el) => (buttonRefs.current["problemType"] = el)}
              ></FontAwesomeIcon>
            </span>
            <TextField
              type="text"
              placeholder="i.e Simpson"
              name="problemType"
              value={problemType}
              onChange={handleProblemType}
              id={"outlined"}
              error={errors.problemType}
              helperText={errors.problemType}
            ></TextField>
          </div>
          <div className="row">
            <span className="rowText">
              Function String
              <FontAwesomeIcon
                icon={faInfo}
                className="info"
                onClick={() => openSideGuide("functionString")}
                ref={(el) => (buttonRefs.current["functionString"] = el)}
              ></FontAwesomeIcon>
            </span>
            <TextField
              type="text"
              placeholder="i.e in Latex: x^2-2"
              name="functionString"
              value={functionString}
              onChange={handleFunctionString}
              id={"outlined"}
              error={errors.functionString}
              helperText={errors.functionString}
            ></TextField>
          </div>
          <div className="row">
            <span className="rowText">
              Problem Data
              <FontAwesomeIcon
                icon={faInfo}
                className="info"
                onClick={() => openSideGuide("problemData")}
                ref={(el) => (buttonRefs.current["problemData"] = el)}
              ></FontAwesomeIcon>
            </span>
            <TextField
              type="text"
              placeholder="i.e {iterations:2}"
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
      <div className={`sideGuideContainer ${showGuide ? "open" : ""}`}>
        <div className="sideGuide">
          <div>
            {highlightedField && guideContent[highlightedField] ? (
              <div>
                <div className="titleguide">
                  {guideContent[highlightedField].title}
                </div>
                <div className="bodyGuide">
                  {guideContent[highlightedField].body}
                </div>
              </div>
            ) : (
              <div></div>
            )}
          </div>
        </div>
      </div>
    </div>
  );
};
export default ProblemComponent;
