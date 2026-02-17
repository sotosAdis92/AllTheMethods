import { faPlus } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Button, Tooltip } from "@mui/material";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { listAchievements } from "../services/AchievementService";
import Achievement from "./Achievement";
import AchievementImage from "./AchievementImage";
const ListAchievements = () => {
  const [achievements, setAchievements] = useState([]);
  const navigator = useNavigate();
  useEffect(() => {
    listAchievements()
      .then((response) => {
        setAchievements(response.data);
        console.log("Api response:", response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  const addNewAchievement = () => {
    navigator("/addAchievement");
  };

  const listOfAchievements = achievements.map((achievement) => (
    <Achievement key={achievement.achievementId} rank={achievement.rank}>
      {achievement.name}
      {achievement.description}
      <AchievementImage category={achievement.category}></AchievementImage>
    </Achievement>
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
