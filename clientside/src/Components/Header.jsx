import { faUser } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Button } from "@mui/material";
import { useEffect, useState } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import img2 from "../assets/door.png";
import img1 from "../assets/logo.JPG";
import { isTokenValid, removeToken } from "../environment/common";
import { getUser } from "../services/UsersService";
import "./Header.css";
const Header = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const [isUserLoggedIn, setIsUserLoggedIn] = useState(false);
  const [displayName, setDisplayName] = useState("");

  const userDisplayName = async () => {
    const isLoggedIn = isTokenValid();
    setIsUserLoggedIn(isLoggedIn);
    try {
      if (isLoggedIn) {
        const response = await getUser();
        setDisplayName(response.data.displayName);
      }
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    try {
      userDisplayName();
    } catch (error) {
      console.log(error);
    }
  }, [location]);

  const handleSignOut = () => {
    navigate("/login");
    removeToken();
  };

  useEffect(() => {
    const interval = setInterval(() => {
      if (!isTokenValid()) {
        setIsUserLoggedIn(false);
        handleSignOut();
      }
    }, 1000000);
    return () => clearInterval(interval);
  }, [handleSignOut]);

  const isActive = (path) => {
    return location.pathname === path;
  };
  return (
    <>
      {isUserLoggedIn ? (
        <div className="container">
          <img src={img1} alt={img1}></img>
          <h2 className="title">All The Methods</h2>
          <ul className="links">
            <li className="link">
              <a
                href="/about"
                className={`headerlink ${isActive("/about") ? "active" : ""}`}
              >
                About
              </a>
            </li>
            <li className="link">
              <a
                href="/problems"
                className={`headerlink ${isActive("/problems") ? "active" : ""}`}
              >
                Problems
              </a>
            </li>
            <li className="link">
              <a
                href="/achievements"
                className={`headerlink ${isActive("/achievements") ? "active" : ""}`}
              >
                Achievements
              </a>
            </li>
            <li className="link">
              <a
                href="/profile"
                className={`headerlink ${isActive("/profile") ? "active" : ""}`}
              >
                Profile
              </a>
            </li>
          </ul>
          <div className="userAndLogout">
            <div className="usersDisplay">
              <FontAwesomeIcon icon={faUser}></FontAwesomeIcon>
              {displayName}
            </div>
            <Button
              variant="contained"
              className="logout"
              onClick={handleSignOut}
            >
              Logout
              <img src={img2} alt={img2}></img>
            </Button>
          </div>
        </div>
      ) : (
        <>
          <div className="loginSingUp-container">
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
          </div>
        </>
      )}
    </>
  );
};
export default Header;
