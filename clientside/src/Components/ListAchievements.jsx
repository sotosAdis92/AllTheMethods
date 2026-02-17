import { faPlus } from "@fortawesome/free-solid-svg-icons";
import { Button, Tooltip } from "@mui/material";
import { useEffect, useState } from "react";
import { listAchievements } from "../services/AchievementService";
import Achievement from "./Achievement";
import AchievementImage from "./AchievementImage";

const ListAchievements = () => {
  const [achievements, setAchievements] = useState([]);

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
        <Button>
          <FontAwesomeIcon icon={faPlus}></FontAwesomeIcon>
        </Button>
      </Tooltip>
      <ol>{listOfAchievements}</ol>
    </>
  );
};
export default ListAchievements;
