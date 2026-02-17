import img1 from "../assets/integral.png";
const AchievementImage = (props) => {
  if (props.category === "Polynomial Roots") {
    return <img src=""></img>;
  } else if (props.category === "Integrals") {
    return <img src={img1}></img>;
  } else if (props.category === "Paremboles") {
    return <img src=""></img>;
  } else if (props.category === "Linear Systems") {
    return <img src=""></img>;
  } else if (props.category === "Derivatives") {
    return <img src=""></img>;
  } else if (props.category === "Differential Equations") {
    return <img src=""></img>;
  }
};
export default AchievementImage;
