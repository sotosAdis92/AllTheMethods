import "./Footer.css";
const Footer = () => {
  const date = new Date();
  let year = date.getFullYear();
  return (
    <>
      <div className="containerFooter">
        <div className="nameOfApp">
          <img></img>
          <h3>All The Methods</h3>
        </div>
        <div className="footerDesc">
          <p>
            Learn numerical analysis algorithms and methods through solving
            problems and earning medals in a gamified experience.
          </p>
        </div>
        <div className="reserved">
          <div className="rights">
            ©{year} AllTheMethods. All Rights Reserved
          </div>
          <div className="developerName">Created by sotosAdis92</div>
        </div>
      </div>
    </>
  );
};
export default Footer;
