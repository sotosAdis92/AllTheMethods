import { Button } from "@mui/material";
import { useEffect, useState } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import { isTokenValid, removeToken } from "../enviroment/common";
import "./Header.css";
const Header = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const [isUserLoggedIn, setIsUserLoggedIn] = useState(false);

  const handleSignOut = () => {
    navigate("/login");
    removeToken();
  };

  useEffect(() => {
    const isLoggedIn = isTokenValid();
    setIsUserLoggedIn(isLoggedIn);
  }, [location]);

  useEffect(() => {
    const interval = setInterval(() => {
      if (!isTokenValid()) {
        setIsUserLoggedIn(false);
        handleSignOut();
      }
    }, 1000000);
    return () => clearInterval(interval);
  }, [handleSignOut]);
  return (
    <>
      {isUserLoggedIn ? (
        <div className="container">
          <h2 className="title">All The Methods</h2>
          <ul className="links">
            <li className="link">
              <a href="/" className="headerlink">
                Announcements
              </a>
            </li>
            <li className="link">
              <a href="/" className="headerlink">
                Problems
              </a>
            </li>
            <li className="link">
              <a href="/achievements" className="headerlink">
                Achievements
              </a>
            </li>
            <li className="link">
              <a href="/profile" className="headerlink">
                My Profile
              </a>
            </li>
          </ul>
          <Button color="inherit" onClick={handleSignOut}>
            Logout
          </Button>
        </div>
      ) : (
        <>
          <Button
            className="loginSingUp"
            LinkComponent={Link}
            variant="contained"
            to="/login"
          >
            Login
          </Button>
          <Button
            className="loginSingUp"
            LinkComponent={Link}
            variant="contained"
            to="/register"
          >
            Sign Up
          </Button>
        </>
      )}
    </>
  );
};
export default Header;
