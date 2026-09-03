import { useEffect, useState } from "react";
import "../../App.css";
import img1 from "../../assets/223399.png";
import img2 from "../../assets/5110770.png";
import img3 from "../../assets/filter.png";
import {
  getAchievementsByCategoryAndRank,
  listAchievements,
} from "../../services/AchievementService";
import BackToTopButton from "../Util/BackToTopButton";
import Achievement from "./Achievement";
import AchievementImage from "./AchievementImage";
import AchievementRank from "./AchievementRankComponent";
import Icon from "./Icon";

const ListAchievements = () => {
  const [achievements, setAchievements] = useState([]);
  const [achievementFilters, setAchievementFilters] = useState([]);
  const [allAchievements, setAllAchievements] = useState([]);
  const [openFilterBool, setOpenFilterBool] = useState(false);
  const [activeCategoryFilters, setActiveCategoryFilters] = useState([]);
  const [activeRankFilters, setActiveRankFilters] = useState([]);

  const getAllAchievements = () => {
    listAchievements()
      .then((response) => {
        setAchievements(response.data);
        setAchievementFilters(response.data);
        setAllAchievements(response.data);
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

  useEffect(() => {
    applyFilters();
  }, [activeCategoryFilters, activeRankFilters]);

  const applyFilters = async () => {
    try {
      const response = await getAchievementsByCategoryAndRank(
        activeCategoryFilters,
        activeRankFilters,
      );
      setAchievements(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  const categoryFilters = [
    ...new Set(achievementFilters.map((achievement) => achievement.category)),
  ];

  const rankFilters = [
    ...new Set(achievementFilters.map((achievement) => achievement.rank)),
  ];

  const handleClickCategoryFilter = (value) => {
    setActiveCategoryFilters((prev) => {
      if (prev.includes(value)) {
        return prev.filter((item) => item !== value);
      } else {
        return [...prev, value];
      }
    });
  };

  const handleClickRankFilter = (value) => {
    setActiveRankFilters((prev) => {
      if (prev.includes(value)) {
        return prev.filter((item) => item != value);
      } else {
        return [...prev, value];
      }
    });
  };

  const listOfCategoryFilters = categoryFilters.map((filter, i) => {
    const isSelected = activeCategoryFilters.includes(filter);

    return (
      <div key={filter}>
        <button
          onClick={() => handleClickCategoryFilter(filter)}
          className={`filters ${isSelected ? "special-active-class" : ""}`}
        >
          <div className="filterImage">
            <AchievementImage category={filter}></AchievementImage>
          </div>
          <div>{filter}</div>
        </button>
      </div>
    );
  });

  const listOfRankFilters = rankFilters.map((filter, i) => {
    const isSelected = activeRankFilters.includes(filter);
    return (
      <div key={filter}>
        <button
          onClick={() => handleClickRankFilter(filter)}
          className={`filters ${isSelected ? "special-active-class" : ""}`}
        >
          <AchievementRank rank={filter}></AchievementRank>
        </button>
      </div>
    );
  });

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
        <div className="filterContainerAchievements ">
          <button
            className="openFilterButtonAchievements  tooltip-container"
            onClick={() => setOpenFilterBool(!openFilterBool)}
          >
            <img src={img3}></img>
            <span className="tooltip">Filters</span>
          </button>
          {!openFilterBool ? (
            <div></div>
          ) : (
            <div className="filtersDiv">
              <button
                onClick={() => getAllAchievements()}
                className="filterButton"
              >
                <img src={img2} className="allAchFilterImg"></img>
                All Achievements
              </button>
              <div>
                <h3 className="categoryHeading">Is of Category:</h3>
                <ol className="filterCategories">{listOfCategoryFilters}</ol>
              </div>
              <div>
                <h3 className="categoryHeading">Is of Rank:</h3>
                <ol className="filterCategories">{listOfRankFilters}</ol>
              </div>
            </div>
          )}
        </div>

        <ol className="listOfAchievements">{listOfAchievements}</ol>
      </div>
      <BackToTopButton></BackToTopButton>
    </>
  );
};
export default ListAchievements;
