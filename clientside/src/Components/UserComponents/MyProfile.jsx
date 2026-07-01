import { useEffect, useState } from "react";
import { getUser } from "../../services/UsersService";
import ViewMyAchievements from "./ViewMyAchievements";
import ViewMyProblems from "./ViewMyProblems";
const MyProfile = () => {
  const [displayName, setDisplayName] = useState("");
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
      <div className="containerUser">
        <h1 className="user">
          My Name: <div className="usersName">{displayName}</div>
        </h1>
      </div>
      <div className="viewAchievements">
        <ViewMyAchievements></ViewMyAchievements>
      </div>
      <div className="viewProblems">
        <ViewMyProblems></ViewMyProblems>
      </div>
    </>
  );
};
export default MyProfile;
