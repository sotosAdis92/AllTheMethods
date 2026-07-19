import { Lock, User } from "@boxicons/react";
import { InputAdornment } from "@mui/material";
import Button from "@mui/material/Button";
import Link from "@mui/material/Link";
import TextField from "@mui/material/TextField";
import { useSnackbar } from "notistack";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { saveToken } from "../../environment/common";
import { login } from "../../services/auth";
import AboutTitle from "../AboutPage/AboutTitle";
import "./LoginSignup.css";
const Login = () => {
  const { enqueueSnackbar } = useSnackbar();
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
      const formData = {
        username,
        password,
      };
      try {
        const response = await login(formData);
        if (response.status === 200) {
          const responseData = response.data;
          saveToken(responseData.jwtToken);
          navigate("/dashboard");
          enqueueSnackbar(`Welcome ${responseData.name}`, {
            variant: "success",
            autoHideDuration: 5000,
          });
        }
      } catch (error) {
        enqueueSnackbar("Sign in failed", {
          variant: error,
          autoHideDuration: 5000,
        });
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
              id="username"
              className="login-input"
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
              id="password"
              className="login-input"
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
            <Button
              type="submit"
              fullWidth
              className="login-button"
              variant="contained"
              onClick={handleSubmit}
            >
              Log In
            </Button>
          </div>
          <div className="row">
            <Link
              variant="body2"
              className="singup-link"
              onClick={() => navigate("/register")}
            >
              {"Don't have an account? Sign Up"}
            </Link>
          </div>
        </div>
      </div>
    </>
  );
};

export default Login;
