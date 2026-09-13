import { useNavigate } from "react-router-dom";
import "./ProblemTypesComponent.css";
const ProblemCategoriesComponent = ({ problemTypes }) => {
  const navigator = useNavigate();
  return (
    <div className="problemTypeContainer">
      <div className="problemType">
        {problemTypes.map((problemType, i) => (
          <div
            className="type"
            key={i}
            onClick={() => navigator(`/${problemType}`)}
          >
            {problemType}
          </div>
        ))}
      </div>
    </div>
  );
};
export default ProblemCategoriesComponent;
