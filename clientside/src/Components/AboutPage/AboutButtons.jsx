import img from "../../assets/github.png";
const AboutButtons = () => {
  return (
    <>
      <div className="wrapper">
        <div className="icon">
          <div className="tooltip">Github</div>
          <span className="spanIcon">
            <img className="imageIconSpan" src={img}></img>
          </span>
        </div>
      </div>
    </>
  );
};
export default AboutButtons;
