import img1 from "../../assets/github.png";

const AboutButtons = () => {
  return (
    <>
      <div className="container">
        <div className="icons">
          <a href="https://github.com/sotosAdis92"></a>
          <span className="spanIcon">{}</span>
          <img className="imageIcon" src={img1}></img>
        </div>
      </div>
    </>
  );
};
export default AboutButtons;
