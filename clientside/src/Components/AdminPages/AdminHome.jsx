import { useState } from "react";
import achievementImg from "../../assets/223399.png";
import submissionsImg from "../../assets/arrows.png";
import problemsImg from "../../assets/list.png";
import userImg from "../../assets/userPicDefault.png";
import AchievementListComponent from "./AchievementListComponent";
import "./AdminHome.css";
import FavoritesComponent from "./FavoritesComponent";
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
    } else if (component === "favorites") {
      return <FavoritesComponent></FavoritesComponent>;
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
          <div>
            <button
              onClick={() => setComponent("favorites")}
              className="navigation-button"
            >
              <svg
                width="28"
                height="28"
                viewBox="0 0 24 24"
                xmlns="http://www.w3.org/2000/svg"
                style={{
                  fill: "#000000",
                  stroke: "none",
                  flexShrink: 0,
                }}
              >
                <path d="M22,9.67A1,1,0,0,0,21.14,9l-5.69-.83L12.9,3a1,1,0,0,0-1.8,0L8.55,8.16,2.86,9a1,1,0,0,0-.81.68,1,1,0,0,0,.25,1l4.13,4-1,5.68a1,1,0,0,0,.4,1,1,1,0,0,0,1.05.07L12,18.76l5.1,2.68a.93.93,0,0,0,.46.12,1,1,0,0,0,.59-.19,1,1,0,0,0,.4-1l-1-5.68,4.13-4A1,1,0,0,0,22,9.67Zm-6.15,4a1,1,0,0,0-.29.89l.72,4.19-3.76-2a1,1,0,0,0-.94,0l-3.76,2,.72-4.19a1,1,0,0,0-.29-.89l-3-3,4.21-.61a1,1,0,0,0,.76-.55L12,5.7l1.88,3.82a1,1,0,0,0,.76.55l4.21.61Z" />
              </svg>
              Favorites
            </button>
          </div>
        </div>
      </div>
      <div className="renderedComponent">{renderComponent()}</div>
    </>
  );
};
export default AdminHome;
