import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import img1 from "../../assets/223399.png";
import img2 from "../../assets/5110770.png";
import img3 from "../../assets/filter.png";
import { listAchievements } from "../../services/AchievementService";
import Achievement from "./Achievement";
import AchievementImage from "./AchievementImage";
import Icon from "./Icon";

const ListAchievements = () => {
  const [achievements, setAchievements] = useState([]);
  const [achievementFilters, setAchievementFilters] = useState([]);
  const [allAchievements, setAllAchievements] = useState([]);
  const [openFilterBool, setOpenFilterBool] = useState(false);
  const [activeCategoryFilters, setActiveCategoryFilters] = useState([]);
  const navigator = useNavigate();

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
  }, [activeCategoryFilters]);

  const applyFilters = () => {
    let filtered = allAchievements;
    if (activeCategoryFilters.length > 0) {
      filtered = filtered.filter((achievement) =>
        activeCategoryFilters.includes(achievement.category),
      );
    }
    setAchievements(filtered);
  };

  const categoryFilters = [
    ...new Set(achievementFilters.map((achievement) => achievement.category)),
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

  const listOfFilters = categoryFilters.map((filter, i) => {
    const isSelected = activeCategoryFilters.includes(filter);
    return (
      <div key={i}>
        <button
          onClick={() => handleClickCategoryFilter(filter)}
          className={`filters ${isSelected ? "special-active-class" : ""}`}
        >
          <div className="filterImage">
            <AchievementImage category={filter}></AchievementImage>
          </div>
          {filter}
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
        <div className="filterContainer">
          <button
            className="openFilterButton"
            onClick={() => setOpenFilterBool(!openFilterBool)}
          >
            <img src={img3}></img>
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
                <ol className="filterCategories">{listOfFilters}</ol>
              </div>
            </div>
          )}
        </div>

        <ol className="listOfAchievements">{listOfAchievements}</ol>
      </div>
    </>
  );
};
export default ListAchievements;
