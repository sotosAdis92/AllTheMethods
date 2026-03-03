import {
  faPencil,
  faPlus,
  faTrashCan,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Button, Tooltip } from "@mui/material";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import img1 from "../assets/223399.png";
import {
  deleteAchievement,
  listAchievements,
} from "../services/AchievementService";
import Achievement from "./Achievement";
import AchievementImage from "./AchievementImage";
import Icon from "./Icon";
const ListAchievements = () => {
  const [achievements, setAchievements] = useState([]);
  const navigator = useNavigate();

  const getAllAchievements = () => {
    listAchievements()
      .then((response) => {
        setAchievements(response.data);
        console.log("Api response:", response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };
  useEffect(() => {
    getAllAchievements();
  }, []);

  const addNewAchievement = () => {
    navigator("/addAchievement");
  };

  const updateAchievement = (id) => {
    navigator(`/updateAchievements/${id}`);
  };

  const removeAchievement = (id) => {
    console.log(id);
    deleteAchievement(id)
      .then(() => {
        getAllAchievements();
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const categoryFilters = [
    ...new Set(achievements.map((achievement) => achievement.category)),
  ];
  const listOfFilters = categoryFilters.map((filter, i) => (
    <div key={i}>
      <button>{filter}</button>
    </div>
  ));

  const listOfAchievements = achievements.map((achievement) => (
    <div key={achievement.achievementId} className="achievementCardWrapper">
      <Achievement rank={achievement.rank}>
        <Icon rank={achievement.rank}>
          <AchievementImage category={achievement.category}></AchievementImage>
        </Icon>
        <div className="achTitle">{achievement.name}</div>
        <div className="achDesc">{achievement.description}</div>
        <img src={img1}></img>
      </Achievement>
      <Button
        variant="contained"
        onClick={() => updateAchievement(achievement.achievementId)}
      >
        <FontAwesomeIcon icon={faPencil}></FontAwesomeIcon>
      </Button>
      <Button
        variant="contained"
        onClick={() => removeAchievement(achievement.achievementId)}
      >
        <FontAwesomeIcon icon={faTrashCan}></FontAwesomeIcon>
      </Button>
    </div>
  ));

  return (
    <>
      <div className="achievementsListContainer">
        <h2 className="achievementsTitle">List Of Achievements</h2>
        {listOfFilters}
        <Tooltip>
          <Button variant="contained" onClick={addNewAchievement}>
            <FontAwesomeIcon icon={faPlus}></FontAwesomeIcon>
          </Button>
        </Tooltip>
        <ol>{listOfAchievements}</ol>
      </div>
    </>
  );
};
export default ListAchievements;
