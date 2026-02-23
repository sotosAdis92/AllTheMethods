import { Typography } from "@mui/material";
import Button from "@mui/material/Button";
import Link from "@mui/material/Link";
import TextField from "@mui/material/TextField";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const [errors, setErrors] = useState({
    username: "",
    password: "",
  });

  const handleUsername = (e) => {
    setUsername(e.target.value);
  };
  const handlePassword = (e) => {
    setPassword(e.target.value);
  };

  function validateForm() {
    let valid = true;
    const errorsCopy = { ...errors };
    if (username.trim()) {
      errorsCopy.username = "";
    } else {
      errorsCopy.username = "Error, username cannot be blank";
      valid = false;
    }
    if (password.trim()) {
      errorsCopy.password = "";
    } else {
      errorsCopy.password = "Error, password cannot be blank";
      valid = false;
    }
    setErrors(errorsCopy);
    return valid;
  }
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (validateForm()) {
      console.log(username);
      console.log(password);
    }
  };
  return (
    <>
      <div className="card">
        <Typography component="h1" variant="h5">
          Log In
        </Typography>
        <div className="row">
          <TextField
            id="username"
            fullWidth
            required
            label="Username"
            name="username"
            autoComplete="username"
            autoFocus
            value={username}
            error={errors.username}
            helperText={errors.username}
            onChange={handleUsername}
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
            value={password}
            error={errors.password}
            helperText={errors.password}
            onChange={handlePassword}
          ></TextField>
        </div>
        <div className="row">
          <Button
            type="submit"
            fullWidth
            variant="contained"
            onClick={handleSubmit}
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
