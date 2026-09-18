import bisection from "../../assets/bisection.png";
import circles from "../../assets/circles.png";
const ProblemTypeImage = (props) => {
  if (props.type === "Bisection") {
    return <img src={bisection} className="imageType"></img>;
  } else if (props.type === "Gershgorin-Circles") {
    return <img src={circles} className="imageType"></img>;
  }
};
export default ProblemTypeImage;
