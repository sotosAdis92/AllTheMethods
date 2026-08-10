import { faTrashCan } from "@fortawesome/free-solid-svg-icons";
import { faPencil } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
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

  const deleteAchievement = (achievementId) => {
    deleteAchievement(achievementId);
  };

  const listOfAchievements = achievements.map((achievement) => (
    <div key={achievement.id} className="achievement-item-table">
      <div>{achievement.id}</div>
      <div>{achievement.name}</div>
      <div>{achievement.description}</div>
      <div>{achievement.category}</div>
      <div>{achievement.rank}</div>
      <div>
        <button
          className="edit-btn-table"
          onClick={() => deleteAchievement(achievement.id)}
        >
          <FontAwesomeIcon icon={faPencil} />
        </button>
        <button
          className="delete-btn-table"
          onClick={() => deleteAchievement(achievement.id)}
        >
          <FontAwesomeIcon icon={faTrashCan} />
        </button>
      </div>
    </div>
  ));

  return (
    <div>
      <div>{listOfAchievements}</div>
    </div>
  );
};
export default AchievementListComponent;
