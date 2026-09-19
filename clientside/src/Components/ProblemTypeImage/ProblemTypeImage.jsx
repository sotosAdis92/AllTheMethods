import bisection from "../../assets/bisection.png";
import circles from "../../assets/circles.png";
import deuler from "../../assets/deuler.png";
import fivepoint from "../../assets/fivepoint.png";
import simpson from "../../assets/simpson.png";
import trapezodial from "../../assets/trapezodial.png";
const ProblemTypeImage = (props) => {
  if (props.type === "Bisection") {
    return <img src={bisection} className="imageType"></img>;
  } else if (props.type === "Gershgorin-Circles") {
    return <img src={circles} className="imageType"></img>;
  } else if (props.type === "Trapezodial-Rule") {
    return <img src={trapezodial} className="imageType"></img>;
  } else if (props.type === "Direct-Euler") {
    return <img src={deuler} className="imageType"></img>;
  } else if (props.type === "Simpson") {
    return <img src={simpson} className="imageType"></img>;
  } else if (props.type === "Five-Point-Derivative") {
    return <img src={fivepoint} className="imageType"></img>;
  }
};
export default ProblemTypeImage;
