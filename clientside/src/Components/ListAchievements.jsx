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
      .then((response) => {
        getAllAchievements();
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const listOfAchievements = achievements.map((achievement) => (
    <div key={achievement.achievementId}>
      <Achievement rank={achievement.rank}>
        <AchievementImage category={achievement.category}></AchievementImage>
        {achievement.name}
        {achievement.description}
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
      <h2 className="achievementsTitle">List Of Achievements</h2>
      <Tooltip>
        <Button variant="contained" onClick={addNewAchievement}>
          <FontAwesomeIcon icon={faPlus}></FontAwesomeIcon>
        </Button>
      </Tooltip>
      <ol>{listOfAchievements}</ol>
    </>
  );
};
export default ListAchievements;
