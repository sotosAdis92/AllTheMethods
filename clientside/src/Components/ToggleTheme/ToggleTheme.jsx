import { faMoon, faSun } from "@fortawesome/free-regular-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import "./ToggleTheme.css";
const ToggleTheme = () => {
  return (
    <div>
      <input type="checkbox" id="themeswitchcheckbox"></input>
      <label htmlFor="themeswitchcheckbox" className="label">
        <FontAwesomeIcon
          icon={faMoon}
          className="fas fa-moon"
        ></FontAwesomeIcon>
        <FontAwesomeIcon icon={faSun} className="fas fa-sun"></FontAwesomeIcon>
        <div className="ball"></div>
      </label>
    </div>
  );
};
export default ToggleTheme;
