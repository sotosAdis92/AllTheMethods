import { useState } from "react";
import { listAchievements } from "../services/AchievementService";
import { AchievementImage } from "./AchievementImage";

const ListAchievements = () => {
  const [achievements, setAchievements] = useState([]);
  listAchievements()
    .then((response) => {
      setAchievements(response.data);
    })
    .catch((error) => {
      console.error(error);
    });
  const listOfAchievements = achievements.map((achievement) => (
    <div key={achievement.id}>
      <AchievementImage value={achievement.category}></AchievementImage>
      {achievement.name}
      {achievement.description}
    </div>
  ));
  return <ol>{listOfAchievements}</ol>;
};
export default ListAchievements;
