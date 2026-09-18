import bisection from "../../assets/bisection.png";

const ProblemTypeImage = (props) => {
  if (props.type === "Bisection") {
    return <img src={bisection} className="imageType"></img>;
  }
};
export default ProblemTypeImage;
