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
        <div class="footerDesc">
          <p></p>
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
