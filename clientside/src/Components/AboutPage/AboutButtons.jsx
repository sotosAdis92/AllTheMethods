import img from "../../assets/github.png";
const AboutButtons = () => {
  return (
    <>
      <div className="wrapper">
        <h3 className="paragraphHeading">Project Source Code</h3>
        <div className="icon">
          <div className="tooltip">Github</div>
          <a href="https://github.com/sotosAdis92/AllTheMethods">
            <span className="spanIcon">
              <img className="imageIconSpan" src={img}></img>
            </span>
          </a>
        </div>
      </div>
    </>
  );
};
export default AboutButtons;
