import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
const Login = () => {
  const [formData, setFormData] = useState({
    username: "",
    password: "",
  });
  const navigate = useNavigate();
  const handleInputChange = async (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSumbit = async (e) => {
    e.preventDefault();
    console.log(formData);
  };
  return (
    <>
      <div className="card">
        <div className="row">
          <TextField
            id="username"
            label="Username"
            name="username"
            autoComplete="username"
            autoFocus
            value={formData.username}
            onChange={handleInputChange}
          ></TextField>
        </div>
        <div className="row">
          <TextField
            id="password"
            label="Password"
            name="password"
            autoComplete="current-password"
            type="password"
            autoFocus
            value={formData.password}
            onChange={handleInputChange}
          ></TextField>
        </div>
        <div className="row">
          <Button type="submit" variant="contained">
            Log In
          </Button>
        </div>
      </div>
    </>
  );
};

export default Login;
