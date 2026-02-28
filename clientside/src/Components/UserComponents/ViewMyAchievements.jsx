import { useEffect, useState } from "react";
import { getUserAchievements } from "../../services/UserAchievementService";
const ViewMyAchievements = () => {
  const [myAchievements, setMyAchievements] = useState([]);

  const getAllUserAchievements = () => {
    getUserAchievements()
      .then((response) => {
        setMyAchievements(response.data);
        console.log("Api response:", response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  useEffect(() => {
    getAllUserAchievements();
  }, []);

  const listOfMyAchievements = myAchievements.map((myAchievement) => (
    <div key={myAchievement.userAchievementId}>
      {myAchievement.name}
      {myAchievement.rank}
    </div>
  ));
  return (
    <>
      <h1>View User Achievements Works</h1>
      <ol>{listOfMyAchievements}</ol>
    </>
  );
};
export default ViewMyAchievements;
