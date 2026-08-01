import { useEffect, useState } from "react";
import "../../App.css";
import img2 from "../../assets/223399.png";
import img1 from "../../assets/trophy.png";
import { getUserAchievements } from "../../services/UserAchievementService";
import AchievementRank from "./AchievementRankComponent";
import "./ViewMyAchievements.css";
const ViewMyAchievements = (props) => {
  const [myAchievements, setMyAchievements] = useState([]);
  const userId = props.userId;
  console.log("AAAAAAAAA", userId);
  const count = myAchievements.filter(
    (myAchievement) => myAchievement.achievementId,
  ).length;

  const getAllUserAchievements = () => {
    getUserAchievements(userId)
      .then((response) => {
        setMyAchievements(response.data);
        console.log("AAAAAAAAAAA", userId);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  useEffect(() => {
    if (userId) {
      getAllUserAchievements();
    }
  }, [userId]);

  const listOfMyAchievements = myAchievements.map((myAchievement) => (
    <div key={myAchievement.achievementId} className="userAchievement">
      <div>{myAchievement.name}</div>
      <div>
        <AchievementRank rank={myAchievement.rank}></AchievementRank>
      </div>
    </div>
  ));

  return (
    <>
      {count > 0 ? (
        <>
          <div className="achievementsContainer">
            <div className="imageAndText">
              <div className="plainText">
                <h1 className="achievementsHeader">
                  <img src={img2} className="image"></img>
                  <div className="headerText">Achievements</div>
                </h1>
                <div className="achievementsCounter">
                  Achievements earned:
                  <div className="earnedCounter">
                    {count}
                    <div className="achievementSupperText">Achievements</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
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
