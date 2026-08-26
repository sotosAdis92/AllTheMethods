import { useEffect, useState } from "react";
import { getUser } from "../../services/UsersService";
import BackToTopButton from "../Util/BackToTopButton";
import ProgressChart from "./ProgressChart";
import UserIcon from "./UserIcon";
import UserSkills from "./UserSkills";
import UserSummaryReport from "./UserSummaryReport";
import ViewMyAchievements from "./ViewMyAchievements";
import ViewMyProblems from "./ViewMyProblems";
import ViewMySumbissionsHistory from "./ViewMySubmissionsHistory";

const MyProfile = () => {
  const [displayName, setDisplayName] = useState("");
  const [userId, setUserId] = useState("");
  const [username, setUsername] = useState("");

  const userDisplayName = () => {
    getUser()
      .then((response) => {
        setDisplayName(response.data.displayName);
        setUserId(response.data.id);
        setUsername(response.data.username);
        console.log("Api response:", response.data.displayName);
        console.log("Api response:", response.data.id);
        console.log(response.data.username);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  useEffect(() => {
    userDisplayName();
  }, []);

  return (
    <>
      <div className="profilePageWrapper">
        <div className="containerUser">
          <h1 className="user">
            <div className="usersName">
              <UserIcon
                displayName={displayName}
                username={username}
                userId={userId}
              ></UserIcon>
            </div>
          </h1>
        </div>
        <div className="content">
          <div className="skillsContainer">
            <UserSkills userId={userId}></UserSkills>
          </div>
          <div className="rowInContent">
            <div>
              <ProgressChart
                userId={userId}
                displayName={displayName}
              ></ProgressChart>
            </div>
            <div>
              <UserSummaryReport userId={userId}></UserSummaryReport>
            </div>
          </div>

          <div className="viewProblems">
            <ViewMyProblems userId={userId}></ViewMyProblems>
          </div>
          <div className="viewAchievements">
            <ViewMyAchievements userId={userId}></ViewMyAchievements>
          </div>
          <div className="viewSubmissions">
            <ViewMySumbissionsHistory
              userId={userId}
            ></ViewMySumbissionsHistory>
          </div>
        </div>
        <BackToTopButton></BackToTopButton>
      </div>
    </>
  );
};
export default MyProfile;
