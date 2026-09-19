import bisection from "../../assets/bisection.png";
import circles from "../../assets/circles.png";
import deuler from "../../assets/deuler.png";
import fivepoint from "../../assets/fivepoint.png";
import newtonraphson from "../../assets/newtonraphson.png";
import richardson from "../../assets/richardson.png";
import simpson from "../../assets/simpson.png";
import threepoint from "../../assets/threepoint.png";
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
  } else if (props.type === "Three-Point-Derivative") {
    return <img src={threepoint} className="imageType"></img>;
  } else if (props.type === "Newton-Raphson") {
    return <img src={newtonraphson} className="imageType"></img>;
  } else if (props.type === "Richardson") {
    return <img src={richardson} className="imageType"></img>;
  }
};
export default ProblemTypeImage;
