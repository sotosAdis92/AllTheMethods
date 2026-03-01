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
        <h1 className="usersName">My Name</h1>
        <h2 className="user">{displayName}</h2>
      </div>

      <ViewMyAchievements></ViewMyAchievements>
      <ViewMyProblems></ViewMyProblems>
    </>
  );
};
export default MyProfile;
