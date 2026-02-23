import { Typography } from "@mui/material";
import Button from "@mui/material/Button";
import Link from "@mui/material/Link";
import TextField from "@mui/material/TextField";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
const Signup = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [displayName, setDisplayName] = useState("");
  const [errors, setErrors] = useState("");
  const navigate = useNavigate();
  const handleUsername = (e) => {
    setUsername(e.target.value);
  };
  const handlePassword = (e) => {
    setPassword(e.target.value);
  };
  const handleDisplayName = (e) => {
    setDisplayName(e.target.value);
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
    if (displayName.trim()) {
      errorsCopy.displayName = "";
    } else {
      errorsCopy.displayName = "Error, display Name cannot be blank";
      valid = false;
    }
    setErrors(errorsCopy);
    return valid;
  }
  const handleSubmit = async (e) => {
    e.preventDefault();
    if (validateForm()) {
      console.log(username);
      console.log(password);
      console.log(displayName);
    }
  };
  return (
    <>
      <div className="card">
        <Typography component="h1" variant="h5">
          Sign Up
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
          <TextField
            id="displayName"
            required
            fullWidth
            label="Display Name"
            name="displayName"
            autoComplete="displayName"
            autoFocus
            value={displayName}
            error={errors.displayName}
            helperText={errors.displayName}
            onChange={handleDisplayName}
          ></TextField>
        </div>
        <div className="row">
          <Button
            type="submit"
            fullWidth
            variant="contained"
            onClick={handleSubmit}
          >
            Create Account
          </Button>
        </div>
        <div className="row">
          <Link variant="body2" onClick={() => navigate("/login")}>
            {"Already have an account? Log In"}
          </Link>
        </div>
      </div>
    </>
  );
};
export default Signup;
