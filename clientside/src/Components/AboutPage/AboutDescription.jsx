import postgres from "../../assets/progres.jpg";
import react from "../../assets/react.jpg";
import spring from "../../assets/spring.jpg";
const AboutDescription = () => {
  return (
    <>
      <div className="aboutDescription">
        <div className="aboutSection">
          <h3 className="paragraphHeading">What is All The Methods?</h3>
          <p className="aboutDescriptionParagraph">
            An educational app where people can solve problems related to
            numerical analysis, built with a tech stack of PostgreSQL for the
            database, Spring Boot for the backend and React.js for the frontend
            client. The Idea of the app was inspired by a series of notes I took
            for a class of the same subject matter, and I named them, All The
            Methods. All The Methods is a interactive learning experiment that
            has the goal of teaching people some of the most popular Numerical
            Methods for solving complex mathimatical problems in an analytical
            way, instead of a symbolic one like we are used to. It aims to be a
            learning web app, focused on individual progress rather than a
            competitive one. The Web app is heavily inspired by the learning
            tool/Web app "Leetcode", where users are presented with programming
            problems instead of mathimatical ones. I hope you find this Web App
            usefull when you wish to tackle learning a new method or, you could
            say, all of them...
          </p>
          <div className="techStackContainerDiv">
            <h3 className="techStackHeading">Tech Stack:</h3>
            <div className="techStackImages">
              <a href="https://www.postgresql.org/">
                <img src={postgres}></img>
              </a>
              <a href="https://spring.io/projects/spring-framework">
                <img src={spring}></img>
              </a>
              <a href="https://react.dev/">
                <img src={react}></img>
              </a>
            </div>
          </div>
        </div>
        <div className="aboutSection">
          <h3 className="paragraphHeading">How do I use the Website?</h3>
          <p className="aboutDescriptionParagraph">
            The Website is as straight foward as it can possibly be, after you
            have registered with an account, you are presented with the pages of
            the app, the about, problems, achievements and profile page on the
            top navigation bar. Most of your time (hopefully) will be spent in
            the "Problems", where you will be presented with a list of selected
            problems to solve.
          </p>
        </div>
        <div>
          <h3 className="paragraphHeading"></h3>
          <p className="aboutDescriptionParagraph"></p>
        </div>
      </div>
    </>
  );
};
export default AboutDescription;
