import { faCheck, faX } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Button, InputLabel, MenuItem, TextField } from "@mui/material";
import FormControl from "@mui/material/FormControl";
import Select from "@mui/material/Select";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { createAchievement } from "../services/AchievementService";
const AchievementComponent = () => {
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [category, setCategory] = useState("");
  const [rank, setRank] = useState("");
  const [visibility, setVisibility] = useState("");
  const navigator = useNavigate;

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

  function saveAchievement(e) {
    e.preventDefault();
    const achievement = {
      name,
      description,
      category,
      rank,
      visibility,
    };
    console.log(achievement);
    createAchievement(achievement).then((response) => {
      console.log(response.data);
      navigator("/achievements");
    });
  }
  return (
    <div>
      <div className="card">
        <div className="row">
          <TextField
            onChange={handleName}
            value={name}
            type="text"
            placeholder="Enter Achievement name"
            id={"outlined"}
            name="name"
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
          ></TextField>
        </div>
        <div className="row">
          <FormControl sx={{ minWidth: 210 }}>
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
          </FormControl>
        </div>
        <div className="row">
          <FormControl sx={{ minWidth: 210 }}>
            <InputLabel>Rank</InputLabel>
            <Select onChange={handleRank} value={rank}>
              <MenuItem value={"Bronze"}>Bronze</MenuItem>
              <MenuItem value={"Silver"}>Silver</MenuItem>
              <MenuItem value={"Gold"}>Gold</MenuItem>
            </Select>
          </FormControl>
        </div>
        <div className="row">
          <FormControl sx={{ minWidth: 210 }}>
            <InputLabel>Visibility</InputLabel>
            <Select onChange={handleVisibility} value={visibility}>
              <MenuItem value={"Visible"}>Visible</MenuItem>
              <MenuItem value={"Hidden"}>Hidden</MenuItem>
            </Select>
          </FormControl>
        </div>
        <Button variant="contained" color="success" onClick={saveAchievement}>
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
