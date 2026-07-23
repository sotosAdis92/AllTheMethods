import { useEffect, useState } from "react";
import img1 from "../../assets/trophy.png";
import { getUserAchievements } from "../../services/UserAchievementService";
const ViewMyAchievements = (props) => {
  const [myAchievements, setMyAchievements] = useState([]);

  const count = myAchievements.filter(
    (myAchievement) => myAchievement.achievementId,
  ).length;

  const getAllUserAchievements = () => {
    getUserAchievements(props.userId)
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
    <div key={myAchievement.achievementId}>
      <div>{myAchievement.category}</div>
      <div>{myAchievement.name}</div>
      <div>{myAchievement.rank}</div>
    </div>
  ));
  return (
    <>
      {count > 0 ? (
        <>
          <h1 className="achievementsHeader">My Achievements</h1>
          <div className="achievementsCounter">{count} Achievements earned</div>
          <ol className="listOfMyAchievements">{listOfMyAchievements}</ol>
        </>
      ) : (
        <>
          <h1 className="achievementsHeader">My Achievements</h1>
          <div className="achievementsCounter">{count} Achievements earned</div>
          <img src={img1}></img>
          <p className="noAchievemets">No achievements Yet!</p>
        </>
      )}
    </>
  );
};
export default ViewMyAchievements;
