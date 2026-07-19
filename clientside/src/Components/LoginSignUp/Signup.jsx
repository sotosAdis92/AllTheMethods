import { Lock, Monitor, User } from "@boxicons/react";
import { InputAdornment } from "@mui/material";
import Button from "@mui/material/Button";
import Link from "@mui/material/Link";
import TextField from "@mui/material/TextField";
import { useSnackbar } from "notistack";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { saveToken } from "../../environment/common";
import { signup } from "../../services/auth";
import AboutTitle from "../AboutPage/AboutTitle";
import "./LoginSignup.css";
const Signup = () => {
  const { enqueueSnackbar } = useSnackbar();
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
      const formData = {
        username,
        password,
        displayName,
      };
      try {
        const response = await signup(formData);
        if (response.status === 201) {
          const responseData = response.data;
          saveToken(responseData.jwtToken);
          navigate("/dashboard");
          enqueueSnackbar(`Welcome ${responseData.name}`, {
            variant: "success",
            autoHideDuration: 5000,
          });
        }
      } catch (error) {
        if (error.response && error.response.status === 409) {
          enqueueSnackbar("User Already exists", {
            variant: "error",
            autoHideDuration: 5000,
          });
        } else {
          enqueueSnackbar("Sign up failed", {
            variant: "error",
            autoHideDuration: 5000,
          });
        }
      }
    }
  };
  return (
    <>
      <div className="login-container">
        <div className="login-card">
          <AboutTitle></AboutTitle>
          <div className="row">
            <TextField
              className="login-input"
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
              InputProps={{
                endAdornment: (
                  <InputAdornment position="end">
                    <User
                      pack="filled"
                      fill={errors.username ? "#ff3333" : "black"}
                    ></User>
                  </InputAdornment>
                ),
              }}
            ></TextField>
          </div>
          <div className="row">
            <TextField
              className="login-input"
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
              InputProps={{
                endAdornment: (
                  <InputAdornment position="end">
                    <Lock
                      pack="filled"
                      fill={errors.password ? "#ff3333" : "black"}
                    ></Lock>
                  </InputAdornment>
                ),
              }}
            ></TextField>
          </div>
          <div className="row">
            <TextField
              className="login-input"
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
              InputProps={{
                endAdornment: (
                  <InputAdornment position="end">
                    <Monitor
                      pack="filled"
                      fill={errors.username ? "#ff3333" : "black"}
                    ></Monitor>
                  </InputAdornment>
                ),
              }}
            ></TextField>
          </div>
          <div className="row">
            <Button
              className="login-button"
              type="submit"
              fullWidth
              variant="contained"
              onClick={handleSubmit}
            >
              Create Account
            </Button>
          </div>
          <div className="row">
            <Link
              variant="body2"
              className="singup-link"
              onClick={() => navigate("/login")}
            >
              {"Already have an account? Log In"}
            </Link>
          </div>
        </div>
      </div>
    </>
  );
};
export default Signup;
