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
      <h1>My Profile</h1>
      <h2>{displayName}</h2>
      <ViewMyAchievements></ViewMyAchievements>
      <ViewMyProblems></ViewMyProblems>
    </>
  );
};
export default MyProfile;
