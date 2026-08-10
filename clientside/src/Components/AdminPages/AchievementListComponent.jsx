import { useEffect, useState } from "react";
import { listAchievements } from "../../services/AchievementService";
import "./achievementListComponent.css";
const AchievementListComponent = () => {
  const [achievements, setAchievements] = useState([]);
  useEffect(() => {
    listAchievements().then((response) => {
      console.log(response.data);
      setAchievements(response.data);
    });
  }, []);

  const listOfAchievements = achievements.map((achievement) => (
    <div key={achievement.id} className="achievement-item-table">
      <div>{achievement.id}</div>
      <div>{achievement.name}</div>
      <div>{achievement.description}</div>
      <div>{achievement.category}</div>
      <div>{achievement.rank}</div>
    </div>
  ));

  return (
    <div>
      <div>{listOfAchievements}</div>
    </div>
  );
};
export default AchievementListComponent;
