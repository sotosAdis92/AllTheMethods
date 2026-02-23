import { Typography } from "@mui/material";
import Button from "@mui/material/Button";
import Link from "@mui/material/Link";
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
      <Typography component="h1" variant="h5">
        Log In
      </Typography>
      <div className="card">
        <div className="row">
          <TextField
            id="username"
            fullWidth
            required
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
            required
            fullWidth
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
          <Button
            type="submit"
            fullWidth
            variant="contained"
            onClick={handleSumbit}
          >
            Log In
          </Button>
        </div>
        <div className="row">
          <Link variant="body2" onClick={() => navigate("/register")}>
            {"Don't have an account? Sign Up"}
          </Link>
        </div>
      </div>
    </>
  );
};

export default Login;
