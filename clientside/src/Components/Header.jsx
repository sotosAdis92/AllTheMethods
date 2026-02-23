import { Button } from "@mui/material";
import { Link } from "react-router-dom";
import "./Header.css";
const Header = () => {
  return (
    <>
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
        </ul>
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
      </div>
    </>
  );
};
export default Header;
