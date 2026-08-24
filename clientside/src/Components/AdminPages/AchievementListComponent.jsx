import {
  faPencil,
  faPlus,
  faTrashCan,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { listAchievements } from "../../services/AchievementService";
import "./achievementListComponent.css";

const AchievementListComponent = () => {
  const navigator = useNavigate();
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

  const editAchievement = (achievementId) => {
    navigator(`/admin/achievements/update/${achievementId}`);
  };

  const addAchievement = () => {
    navigator("/admin/achievements/add");
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
          onClick={() => editAchievement(achievement.id)}
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
      <div>
        <button className="add-btn-table" onClick={() => addAchievement()}>
          <FontAwesomeIcon icon={faPlus} />
        </button>
      </div>
      <div>
        <div className="headerAchievement achievement-item-table">
          <div>Id</div>
          <div>Name</div>
          <div>Description</div>
          <div>Category</div>
          <div>Rank</div>
        </div>
        {listOfAchievements}
      </div>
    </div>
  );
};
export default AchievementListComponent;
