import { Button } from "@mui/material";
import { useEffect, useState } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import img2 from "../../assets/door.png";
import img1 from "../../assets/logo.JPG";
import userDefaultPic from "../../assets/userPicDefault.png";
import { isTokenValid, removeToken } from "../../environment/common";
import { getUser } from "../../services/UsersService";
import "./Header.css";
const Header = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const [isUserLoggedIn, setIsUserLoggedIn] = useState(false);
  const [displayName, setDisplayName] = useState("");
  const [roleUser, setRoleUser] = useState("");
  const [profilePic, setProfilePic] = useState("");

  const userDisplayName = async () => {
    const isLoggedIn = isTokenValid();
    setIsUserLoggedIn(isLoggedIn);
    try {
      if (isLoggedIn) {
        const response = await getUser();
        setDisplayName(response.data.displayName);
        setRoleUser(response.data.userRole);
        setProfilePic(response.data.image);
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

  const roleCheck = () => {
    return roleUser === "ADMIN";
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
            {roleCheck() && (
              <li className="link">
                <a
                  href="/admin"
                  className={`headerlink ${isActive("/admin") ? "active" : ""}`}
                >
                  Admin
                </a>
              </li>
            )}
          </ul>

          <div className="userAndLogout">
            <div className="themeToggle">
              <button className="buttonThemeToggle" id="themeSwitch">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  height="24px"
                  viewBox="0 -960 960 960"
                  width="24px"
                  fill="#f1c40f"
                >
                  <path d="M480-120q-150 0-255-105T120-480q0-150 105-255t255-105q14 0 27.5 1t26.5 3q-41 29-65.5 75.5T444-660q0 90 63 153t153 63q55 0 101-24.5t75-65.5q2 13 3 26.5t1 27.5q0 150-105 255T480-120Z" />
                </svg>
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  height="24px"
                  viewBox="0 -960 960 960"
                  width="24px"
                  fill="#f39c12"
                >
                  <path d="M338.5-338.5Q280-397 280-480t58.5-141.5Q397-680 480-680t141.5 58.5Q680-563 680-480t-58.5 141.5Q563-280 480-280t-141.5-58.5ZM200-440H40v-80h160v80Zm720 0H760v-80h160v80ZM440-760v-160h80v160h-80Zm0 720v-160h80v160h-80ZM256-650l-101-97 57-59 96 100-52 56Zm492 496-97-101 53-55 101 97-57 59Zm-98-550 97-101 59 57-100 96-56-52ZM154-212l101-97 55 53-97 101-59-57Z" />
                </svg>
              </button>
            </div>
            <div className="usersDisplay">
              <img
                className="profilePic"
                src={profilePic === "" ? userDefaultPic : profilePic}
              ></img>
              <div className="displayOfName">{displayName}</div>
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
