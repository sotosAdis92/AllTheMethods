import img4 from "../assets/4900358-200";
import img3 from "../assets/def.png";
import img6 from "../assets/deriv";
import img1 from "../assets/integral.png";
import img2 from "../assets/root.png";
import img5 from "../assets/system";
const AchievementImage = (props) => {
  if (props.category === "Polynomial Roots") {
    return <img src={img2}></img>;
  } else if (props.category === "Integrals") {
    return <img src={img1}></img>;
  } else if (props.category === "Paremboles") {
    return <img src={img4}></img>;
  } else if (props.category === "Linear Systems") {
    return <img src={img5}></img>;
  } else if (props.category === "Derivatives") {
    return <img src={img6}></img>;
  } else if (props.category === "Differential Equations") {
    return <img src={img3}></img>;
  }
};
export default AchievementImage;
