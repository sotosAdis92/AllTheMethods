import { faCheck, faX } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  Button,
  FormHelperText,
  InputLabel,
  MenuItem,
  TextField,
} from "@mui/material";
import FormControl from "@mui/material/FormControl";
import Select from "@mui/material/Select";
import { useEffect, useState, useRef } from "react";
import { useNavigate, useParams } from "react-router-dom";
import {
  createAchievement,
  getAchievemet,
  updateAchievement,
} from "../services/AchievementService";
const AchievementComponent = () => {
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [category, setCategory] = useState("");
  const [rank, setRank] = useState("");
  const [visibility, setVisibility] = useState("");
  const navigator = useNavigate();
  const { id } = useParams();
  useEffect(() => {
    if (id) {
      getAchievemet(id)
        .then((response) => {
          setName(response.data.name);
          setDescription(response.data.description);
          setCategory(response.data.category);
          setRank(response.data.rank);
          setVisibility(response.data.visibility);
        })
        .catch((error) => {
          console.log(error);
        });
    }
  }, [id]);

  const [errors, setErrors] = useState({
    name: "",
    description: "",
    category: "",
    rank: "",
    visibility: "",
  });

  function validateForm() {
    let valid = true;
    const errorsCopy = { ...errors };
    if (name.trim()) {
      errorsCopy.name = "";
    } else {
      errorsCopy.name = "name is required";
      valid = false;
    }
    if (description.trim()) {
      errorsCopy.description = "";
    } else {
      errorsCopy.description = "description is required";
      valid = false;
    }
    if (category && category.trim() !== "") {
      errorsCopy.category = "";
    } else {
      errorsCopy.category = "Error, category cannot be empty";
      valid = false;
    }
    if (rank && rank.trim() !== "") {
      errorsCopy.rank = "";
    } else {
      errorsCopy.rank = "Error, rank cannot be empty";
      valid = false;
    }
    if (visibility && visibility.trim() !== "") {
      errorsCopy.visibility = "";
    } else {
      errorsCopy.visibility = "Error, visibility cannot be empty";
      valid = false;
    }

    setErrors(errorsCopy);
    return valid;
  }

  const handleName = (e) => {
    setName(e.target.value);
  };
  const handleDescription = (e) => {
    setDescription(e.target.value);
  };
  const handleCategory = (e) => {
    setCategory(e.target.value);
  };
  const handleRank = (e) => {
    setRank(e.target.value);
  };
  const handleVisibility = (e) => {
    setVisibility(e.target.value);
  };

  function saveOrUpdateAchievement(e) {
    e.preventDefault();
    if (validateForm()) {
      const achievement = {
        name,
        description,
        category,
        rank,
        visibility,
      };
      if (id) {
        updateAchievement(id, achievement)
          .then((response) => {
            console.log(response.data);
            navigator("/achievements");
          })
          .catch((error) => {
            console.error(error);
          });
      } else {
        console.log(achievement);
        createAchievement(achievement)
          .then((response) => {
            console.log(response.data);
            navigator("/achievements");
          })
          .catch((error) => {
            console.error(error);
          });
      }
    }
  }

  function pageTitle() {
    if (id) {
      return <h2>Update Achievement</h2>;
    } else {
      return <h2>Create Achievement</h2>;
    }
  }
  return (
    <div>
      {pageTitle()}
      <div className="card">
        <div className="row">
          <TextField
            onChange={handleName}
            value={name}
            type="text"
            placeholder="Enter Achievement name"
            id={"outlined"}
            name="name"
            error={errors.name}
            helperText={errors.name}
          ></TextField>
        </div>
        <div className="row">
          <TextField
            onChange={handleDescription}
            value={description}
            type="text"
            placeholder="Enter Achievement description"
            id={"outlined"}
            name="name"
            error={errors.description}
            helperText={errors.description}
          ></TextField>
        </div>
        <div className="row">
          <FormControl error={errors.category} sx={{ minWidth: 210 }}>
            <InputLabel>Category</InputLabel>
            <Select onChange={handleCategory} value={category}>
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
        <div className="row">
          <FormControl error={errors.rank} sx={{ minWidth: 210 }}>
            <InputLabel>Rank</InputLabel>
            <Select onChange={handleRank} value={rank}>
              <MenuItem value={"Bronze"}>Bronze</MenuItem>
              <MenuItem value={"Silver"}>Silver</MenuItem>
              <MenuItem value={"Gold"}>Gold</MenuItem>
            </Select>
            {errors.rank && <FormHelperText>{errors.rank}</FormHelperText>}
          </FormControl>
        </div>
        <div className="row">
          <FormControl error={errors.visibility} sx={{ minWidth: 210 }}>
            <InputLabel>Visibility</InputLabel>
            <Select onChange={handleVisibility} value={visibility}>
              <MenuItem value={"Visible"}>Visible</MenuItem>
              <MenuItem value={"Hidden"}>Hidden</MenuItem>
            </Select>
            {errors.visibility && (
              <FormHelperText>{errors.visibility}</FormHelperText>
            )}
          </FormControl>
        </div>
        <Button
          variant="contained"
          color="success"
          onClick={saveOrUpdateAchievement}
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
export default AchievementComponent;
