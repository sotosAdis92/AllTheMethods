import Tooltip from "../Tooltip";
const AboutDescription = () => {
  const arrayOfButtons = [
    {
      link: "https://www.postgresql.org/",
      label: "Postgresql",
      picture: "src/assets/progres.jpg",
      style: "Postgresql",
    },
    {
      link: "https://spring.io/projects/spring-boot",
      label: "Spring",
      picture: "src/assets/spring.jpg",
      style: "Spring",
    },
    {
      link: "https://react.dev/",
      label: "React.js",
      picture: "src/assets/react.jpg",
      style: "React",
    },
  ];

  const listOfButtons = arrayOfButtons.map((button, i) => {
    return (
      <Tooltip
        content={button.label}
        styling={`tooltip ${button.style}`}
        key={i}
      >
        <a href={button.link}>
          <span className="spanIcon">
            <img className="imageIconSpan" src={button.picture}></img>
          </span>
        </a>
      </Tooltip>
    );
  });

  return (
    <>
      <div className="aboutDescription">
        <div className="paragraphHeading">What is All The Methods?</div>
        <div className="aboutSection">
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
            <div className="techStackImages">{listOfButtons}</div>
          </div>
        </div>
        <div className="paragraphHeading">How do I use the Website?</div>
        <div className="aboutSection">
          <p className="aboutDescriptionParagraph">
            The Website is as straight foward as it can possibly be, after you
            have registered with an account, you are presented with the pages of
            the app, the about, problems, achievements and profile page on the
            top navigation bar. Most of your time (hopefully) will be spent in
            the "Problems", where you will be presented with a list of selected
            problems to solve.
          </p>
          <p className="aboutDescriptionParagraph">
            The Problems page is where you will find all the problems (haha all
            the problems) to solve, these range from 3 difficulties, titled
            Easy, Med. (Short for Calculator and Medium), and Hard. These were
            based on my personal opinion so if you feel like some easy problems
            are harder than some Medium or Harder problems, do not be angry, it
            might happen. You can navigate the problems by clicking on them, you
            will be directed to the problems page. Submissions are infinite but
            they are tracked and calculated.
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
