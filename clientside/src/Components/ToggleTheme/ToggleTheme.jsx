import { faMoon, faSun } from "@fortawesome/free-regular-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
const ToggleTheme = () => {
  return (
    <div>
      <input type="checkbox" id="themeswitchcheckbox">
        <label for="themeswitchcheckbox" className="label">
          <FontAwesomeIcon icon={faSun}></FontAwesomeIcon>
          <FontAwesomeIcon icon={faMoon}></FontAwesomeIcon>
          <div className="ball"></div>
        </label>
      </input>
    </div>
  );
};
export default ToggleTheme;
