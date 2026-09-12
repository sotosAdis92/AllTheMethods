import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import img2 from "../../assets/5110770.png";
import img from "../../assets/check.png";
import img3 from "../../assets/filter.png";
import { useAuth } from "../../context/AuthContext";
import { getAllUserFavorites } from "../../services/FavouritesService";
import {
  getProblemsByCategoryOrDifficulty,
  listProblems,
} from "../../services/ProblemService";
import {
  getCountDistinctProblems,
  getUserProblemById,
} from "../../services/UserProblemService";
import AchievementImage from "../AchievementScreen/AchievementImage";
import AddToFavoritesStar from "../Favorites/AddToFavoritesStar";
import ProblemDifficulty from "../ProblemDifficulty/ProblemDifficulty";
import BackToTopButton from "../Util/BackToTopButton";
import "./ListProblems.css";

const ListProblems = () => {
  const [problems, setProblems] = useState([]);
  const [allProblems, setAllProblems] = useState([]);
  const [isSolved, setIsSolved] = useState({});
  const [isFavorite, setIsFavorite] = useState({});
  const [favoriteId, setFavoriteId] = useState(0);
  const [problemCategoryFilters, setProblemCategoryFilters] = useState([]);
  const [problemDifficultyFilters, setProblemDifficultyFilters] = useState([]);
  const [openFilterBool, setOpenFilterBool] = useState(false);
  const [activeDifficultyFilters, setActiveDifficultyFilters] = useState([]);
  const [activeCategoryFilters, setActiveCategoryFilters] = useState([]);
  const [countAllProblemsSolved, setAllProblemsSolved] = useState(0);
  const [countAllProblems, setCountAllProblems] = useState(0);
  const { user } = useAuth();
  const userId = user?.id;
  const navigator = useNavigate();

  function getAllProblems() {
    listProblems()
      .then((response) => {
        setAllProblems(response.data);
        setProblems(response.data);
        setProblemCategoryFilters(response.data);
        setProblemDifficultyFilters(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }

  function getUserProblemCount() {
    if (userId) {
      getCountDistinctProblems(userId)
        .then((response) => {
          setAllProblemsSolved(response.data);
          console.log(response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    }
  }

  useEffect(() => {
    getAllProblems();
  }, []);

  useEffect(() => {
    getUserProblemCount();
  }, []);

  useEffect(() => {
    applyFilters();
  }, [activeCategoryFilters, activeDifficultyFilters]);

  const applyFilters = async () => {
    try {
      const response = await getProblemsByCategoryOrDifficulty(
        activeCategoryFilters,
        activeDifficultyFilters,
      );
      setProblems(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  const categoryFilters = [
    ...new Set(problemCategoryFilters.map((problem) => problem.category)),
  ];

  const difficultyFilters = [
    ...new Set(problemDifficultyFilters.map((problem) => problem.difficulty)),
  ];

  const handleClickCategoryFilterProblems = (value) => {
    setActiveCategoryFilters((prevActiveFilters) => {
      if (prevActiveFilters.includes(value)) {
        return prevActiveFilters.filter((item) => item !== value);
      } else {
        return [...prevActiveFilters, value];
      }
    });
  };

  const handleClickDifficultyFilterProblems = (value) => {
    setActiveDifficultyFilters((prev) => {
      if (prev.includes(value)) {
        return prev.filter((item) => item !== value);
      } else {
        return [...prev, value];
      }
    });
  };

  const listOfCategoryFilters = categoryFilters.map((filter, i) => {
    const isSelected = activeCategoryFilters.includes(filter);
    return (
      <div key={i}>
        <button
          onClick={() => handleClickCategoryFilterProblems(filter)}
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

  const listOfDifficultyFilter = difficultyFilters.map((filter, i) => {
    const isSelected = activeDifficultyFilters.includes(filter);
    return (
      <div key={i}>
        <button
          onClick={() => handleClickDifficultyFilterProblems(filter)}
          className={`filters ${isSelected ? "special-active-class" : ""}`}
        >
          <ProblemDifficulty difficulty={filter}></ProblemDifficulty>
        </button>
      </div>
    );
  });

  function navigate(id) {
    navigator("/problems/" + id);
  }

  useEffect(() => {
    problems.forEach((problem) => {
      getUserProblemById(problem.id)
        .then((response) => {
          setIsSolved((previous) => ({
            ...previous,
            [problem.id]: response.data,
          }));
        })
        .catch((error) => {
          console.log(error);
        });
    });
  }, []);

  useEffect(() => {
    if (userId) {
      getAllUserFavorites(userId)
        .then((response) => {
          const favMap = {};
          if (Array.isArray(response.data.content)) {
            response.data.content.forEach((fav) => {
              favMap[fav.problemId] = true;
              setFavoriteId(fav.id);
            });
          }
          setIsFavorite(favMap);
        })
        .catch((error) => {
          console.log(error);
        });
    }
  }, [userId]);

  const date = new Date();
  const dateSent = date.toISOString();

  const listOfProblems = problems
    .sort(function (a, b) {
      return a.number - b.number;
    })
    .map((problem, i) => {
      const data = {
        isFavorite: isFavorite[problem.id],
        user: userId,
        problem: problem.id,
        date: dateSent,
        favoriteId: favoriteId,
      };
      return (
        <div className="problemWithButtons" key={problem.id}>
          <div
            className={i % 2 !== 0 ? "problemOdd" : "problemItem"}
            onClick={() => navigate(problem.id)}
          >
            <a className="problemLink">
              <div className="problemDetails">
                <div className="numberAndTitle">
                  {problem.number}. {problem.title}
                </div>
                {isSolved[problem.id] ? (
                  <div className="checkmark">
                    <img src={img}></img>
                  </div>
                ) : (
                  <div></div>
                )}
                <ProblemDifficulty
                  difficulty={problem.difficulty}
                ></ProblemDifficulty>
                <div className="pointsOfProblem">{problem.points}pts.</div>
              </div>
            </a>
          </div>
          <div>
            <AddToFavoritesStar {...data}></AddToFavoritesStar>
          </div>
        </div>
      );
    });

  return (
    <>
      <div className="problemScreen">
        <h2 className="problemsTitle">List Of Problems</h2>
        <div className="filterContainer">
          <button
            className="openFilterButton tooltip-container"
            onClick={() => setOpenFilterBool(!openFilterBool)}
          >
            <img src={img3}></img>
            <span className="tooltip">Filters</span>
          </button>

          {!openFilterBool ? (
            <div></div>
          ) : (
            <div className="filtersDiv">
              <button onClick={() => getAllProblems()} className="filterButton">
                <img src={img2} className="allAchFilterImg"></img>
                All Problems
              </button>
              <div>
                <h4 className="categoryHeading">Is of Category:</h4>
                <ol className="filterCategories">{listOfCategoryFilters}</ol>
              </div>
              <div>
                <h4 className="categoryHeading">Is of Difficulty:</h4>
                <ol className="filterCategories">{listOfDifficultyFilter}</ol>
              </div>
            </div>
          )}
          <div className="solvedOutOfTotal">
            Solved: {countAllProblemsSolved}
          </div>
        </div>
        <ol className="listOfProblems">{listOfProblems}</ol>
      </div>
      <BackToTopButton></BackToTopButton>
    </>
  );
};
export default ListProblems;
