import { faPlus } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Button, Tooltip } from "@mui/material";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import img1 from "../assets/223399.png";
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
      <AchievementImage category={achievement.category}></AchievementImage>
      {achievement.name}
      {achievement.description}
      <img src={img1}></img>
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
