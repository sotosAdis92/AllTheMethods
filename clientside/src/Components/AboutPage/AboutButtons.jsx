import img1 from "../../assets/github.png";

const AboutButtons = () => {
  return (
    <>
      <div className="containerIcons">
        <div className="icons">
          <div className="tooltip">Github</div>
          <a href="https://github.com/sotosAdis92"></a>
          <span className="spanIcon">Github</span>
          <img className="imageIcon" src={img1}></img>
        </div>
      </div>
    </>
  );
};
export default AboutButtons;
