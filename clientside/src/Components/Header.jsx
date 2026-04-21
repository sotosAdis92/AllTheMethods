import { faUser } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Button } from "@mui/material";
import { useEffect, useState } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import { isTokenValid, removeToken } from "../enviroment/common";
import { getUser } from "../services/UsersService";
import "./Header.css";
const Header = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const [isUserLoggedIn, setIsUserLoggedIn] = useState(false);
  const [displayName, setDisplayName] = useState("");

  const userDisplayName = () => {
    getUser()
      .then((response) => {
        setDisplayName(response.data.displayName);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  useEffect(() => {
    userDisplayName();
  }, []);

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
              <a href="/announcements" className="headerlink">
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
          <div className="userAndLogout">
            <div className="usersDisplay">
              <FontAwesomeIcon icon={faUser}></FontAwesomeIcon>
              {displayName}
            </div>
            <Button variant="contained" onClick={handleSignOut}>
              Logout
            </Button>
          </div>
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
            className="SingUp"
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
