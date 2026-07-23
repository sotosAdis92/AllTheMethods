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
        console.log("Api response:", response.data);
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
          <div className="viewAchievements">
            <ViewMyAchievements props={userId}></ViewMyAchievements>
          </div>
          <div className="viewProblems">
            <ViewMyProblems props={userId}></ViewMyProblems>
          </div>
          <div>
            <ProgressChart></ProgressChart>
          </div>
        </div>
      </div>
    </>
  );
};
export default MyProfile;
