import { useState } from "react";
import achievementImg from "../../assets/223399.png";
import submissionsImg from "../../assets/arrows.png";
import problemsImg from "../../assets/list.png";
import userImg from "../../assets/userPicDefault.png";
import AchievementListComponent from "./AchievementListComponent";
import "./AdminHome.css";
import ProblemListComponent from "./ProblemListComponent";
import SubmissionComponent from "./SubmissionsComponent";
import UsersComponent from "./UsersComponent";
const AdminHome = () => {
  const [component, setComponent] = useState("problems");
  const renderComponent = () => {
    if (component === "problems") {
      return <ProblemListComponent></ProblemListComponent>;
    } else if (component === "achievement") {
      return <AchievementListComponent></AchievementListComponent>;
    } else if (component === "submission") {
      return <SubmissionComponent></SubmissionComponent>;
    } else if (component === "users") {
      return <UsersComponent></UsersComponent>;
    }
  };
  return (
    <>
      <div className="containerAdmin">
        <div className="navigation">
          <div>
            <button
              onClick={() => setComponent("problems")}
              className="navigation-button"
            >
              <img src={problemsImg}></img>
              Problems
            </button>
          </div>
          <div>
            <button
              onClick={() => setComponent("achievement")}
              className="navigation-button"
            >
              <img src={achievementImg}></img>
              Achievements
            </button>
          </div>
          <div>
            <button
              onClick={() => setComponent("submission")}
              className="navigation-button"
            >
              <img src={submissionsImg}></img>
              Submissions
            </button>
          </div>
          <div>
            <button
              onClick={() => setComponent("users")}
              className="navigation-button"
            >
              <img src={userImg}></img>
              Users
            </button>
          </div>
        </div>
      </div>
      <div className="renderedComponent">{renderComponent()}</div>
    </>
  );
};
export default AdminHome;
