import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import img1 from "../../assets/223399.png";
import img2 from "../../assets/5110770.png";
import {
  getAchievementsByCategory,
  listAchievements,
} from "../../services/AchievementService";
import Achievement from "./Achievement";
import AchievementImage from "./AchievementImage";
import Icon from "./Icon";

const ListAchievements = () => {
  const [achievements, setAchievements] = useState([]);
  const [achievementFilters, setAchievementFilters] = useState([]);
  const navigator = useNavigate();

  const getAllAchievements = () => {
    listAchievements()
      .then((response) => {
        setAchievements(response.data);
        setAchievementFilters(response.data);
        console.log(response.data);
        console.log(achievementFilters);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  useEffect(() => {
    getAllAchievements();
  }, []);

  const categoryFilters = [
    ...new Set(achievementFilters.map((achievement) => achievement.category)),
  ];

  const handleClickCategoryFilter = (value) => {
    getAchievementsByCategory(value).then((response) =>
      setAchievements(response.data),
    );
  };

  const listOfFilters = categoryFilters.map((filter, i) => (
    <div key={i}>
      <button
        onClick={() => handleClickCategoryFilter(filter)}
        className="filters"
      >
        <div className="filterImage">
          <AchievementImage category={filter}></AchievementImage>
        </div>
        {filter}
      </button>
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
    </div>
  ));

  return (
    <>
      <div className="achievementScreen">
        <h2 className="achievementsTitle">List Of Achievements</h2>
        <button onClick={() => getAllAchievements()} className="filterButton">
          <img src={img2} className="allAchFilterImg"></img>
          All Achievements
        </button>
        <ol className="filterCategories">{listOfFilters}</ol>
        <ol className="listOfAchievements">{listOfAchievements}</ol>
      </div>
    </>
  );
};
export default ListAchievements;
