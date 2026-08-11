import { useNavigate } from "react-router-dom";
import "./UnauthorizedAccess.css";
const UnauthorizedAccess = () => {
  const navigator = useNavigate();
  return (
    <div className="unauthorized-container">
      <div className="unauthorized-card">
        <div className="error-code">403</div>
        <div className="error-message">Unauthorized Access</div>
        <div>
          <button className="return-button" onClick={() => navigator("/about")}>
            Return to About
          </button>
        </div>
      </div>
    </div>
  );
};
export default UnauthorizedAccess;
