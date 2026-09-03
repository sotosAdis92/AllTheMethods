import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import "../../App.css";
import { getUser } from "../../services/UsersService";
import "../Favorites/AddToFavoritesStar.css";
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
  const navigator = useNavigate();

  const userDisplayName = () => {
    getUser()
      .then((response) => {
        setDisplayName(response.data.displayName);
        setUserId(response.data.id);
        setUsername(response.data.username);
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
          <div className="rowInContent">
            <div className="skillsContainer">
              <UserSkills userId={userId}></UserSkills>
            </div>
            <div className="favoritesList">
              <button
                onClick={() => navigator(`/favorites/${userId}`)}
                className="goToFavoritesButton"
              >
                <svg
                  width="28"
                  height="28"
                  viewBox="0 0 24 24"
                  xmlns="http://www.w3.org/2000/svg"
                  style={{
                    fill: "#f57c00",
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
