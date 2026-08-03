import img1 from "../assets/logo.JPG";
import "./Footer.css";
const Footer = () => {
  const date = new Date();
  let year = date.getFullYear();
  return (
    <>
      <div className="containerFooter">
        <div className="footerContent">
          <div className="footerTop">
            <div className="nameOfApp">
              <img src={img1} alt={img1}></img>
              <h3>All The Methods</h3>
            </div>
            <div className="footerDesc">
              <p>
                Learn numerical analysis algorithms and methods through solving
                problems and earning medals in a gamified experience.
              </p>
            </div>
          </div>

          <div className="reserved">
            <div className="rights">
              ©{year} AllTheMethods. All Rights Reserved
            </div>
            <div className="developerName">Created by sotosAdis92</div>
          </div>
        </div>
      </div>
    </>
  );
};
export default Footer;
