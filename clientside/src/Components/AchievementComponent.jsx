import { TextField } from "@mui/material";
import FormControl from "@mui/material/FormControl";
import Select from "@mui/material/Select";
import { useNavigate } from "react-router-dom";
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
  return (
    <div>
      <div className="card">
        <div className="row">
          <TextField onChange={handleName}></TextField>
        </div>
        <div className="row">
          <TextField onChange={handleDescription}></TextField>
        </div>
        <div className="row">
          <FormControl>
            <Select onChange={handleCategory}></Select>
          </FormControl>
        </div>
        <div className="row">
          <FormControl>
            <Select onChange={handleRank}></Select>
          </FormControl>
        </div>
        <div className="row">
          <FormControl>
            <Select onChange={handleVisibility}></Select>
          </FormControl>
        </div>
      </div>
    </div>
  );
};
export default AchievementComponent;
