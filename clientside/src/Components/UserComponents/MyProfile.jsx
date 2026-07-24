import { useEffect, useState } from "react";
import { getUser } from "../../services/UsersService";
import ProgressChart from "./ProgressChart";
import UserIcon from "./UserIcon";
import ViewMyAchievements from "./ViewMyAchievements";
import ViewMyProblems from "./ViewMyProblems";
const MyProfile = () => {
  const [displayName, setDisplayName] = useState("");
  const [userId, setUserId] = useState("");

  const userDisplayName = () => {
    getUser()
      .then((response) => {
        setDisplayName(response.data.displayName);
        setUserId(response.data.id);
        console.log("Api response:", response.data.displayName);
        console.log("Api response:", response.data.id);
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
              <UserIcon displayName={displayName}></UserIcon>
            </div>
          </h1>
        </div>
        <div className="content">
          <div>
            <ProgressChart
              userId={userId}
              displayName={displayName}
            ></ProgressChart>
          </div>
          <div className="viewProblems">
            <ViewMyProblems props={userId}></ViewMyProblems>
          </div>
          <div className="viewAchievements">
            <ViewMyAchievements props={userId}></ViewMyAchievements>
          </div>
        </div>
      </div>
    </>
  );
};
export default MyProfile;
