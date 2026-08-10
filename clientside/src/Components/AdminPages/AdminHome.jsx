import { useState } from "react";
import AchievementListComponent from "./AchievementListComponent";
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
        <div>
          <button onClick={() => setComponent("problems")}>Problems</button>
        </div>
        <div>
          <button onClick={() => setComponent("achievement")}>
            Achievements
          </button>
        </div>
        <div>
          <button onClick={() => setComponent("submission")}>
            Submissions
          </button>
        </div>
        <div>
          <button onClick={() => setComponent("users")}>Users</button>
        </div>
      </div>
      <div>{renderComponent()}</div>
    </>
  );
};
export default AdminHome;
