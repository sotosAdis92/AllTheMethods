import img from "../../assets/logo.JPG";
import "./About.css";
const AboutTitle = () => {
  return (
    <>
      <div className="aboutTitle">
        <div className="aboutImageWithHeading">
          <img src={img}></img>
          <h2 className="MainTitle">All The Methods</h2>
        </div>
      </div>
    </>
  );
};
export default AboutTitle;
