import bisection from "../../assets/bisection.png";
import circles from "../../assets/circles.png";
import deuler from "../../assets/deuler.png";
import trapezodial from "../../assets/trapezodial.png";
const ProblemTypeImage = (props) => {
  if (props.type === "Bisection") {
    return <img src={bisection} className="imageType"></img>;
  } else if (props.type === "Gershgorin-Circles") {
    return <img src={circles} className="imageType"></img>;
  } else if (props.type === "Trapezodial-Rule") {
    return <img src={trapezodial}></img>;
  } else if (props.type === "Direct-Euler") {
    return <img src={deuler}></img>;
  }
};
export default ProblemTypeImage;
