import { useEffect, useMemo, useState } from "react";
import { useNavigate } from "react-router-dom";
import img2 from "../../assets/5110770.png";
import img from "../../assets/check.png";
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
import ProblemTypesComponent from "../ProblemTypes/ProblemTypesComponent";
import BackToTopButton from "../Util/BackToTopButton";
import "./ListProblems.css";

const ListProblems = () => {
  const [problems, setProblems] = useState([]);
  const [problemType, setProblemType] = useState([]);
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

  useEffect(() => {
    getAllProblems();
    getUserProblemCount();
  }, [userId]);

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

  const typeCount = useMemo(() => {
    const countOfType = {};
    for (const problem of allProblems) {
      const type = problem.problemType;
      if (countOfType[type] === undefined) {
        countOfType[type] = 0;
      }
      countOfType[type] = countOfType[type] + 1;
    }
    return countOfType;
  }, [allProblems]);

  const categoryFilters = [
    ...new Set(problemCategoryFilters.map((problem) => problem.category)),
  ];

  const difficultyFilters = [
    ...new Set(problemDifficultyFilters.map((problem) => problem.difficulty)),
  ];

  const problemTypes = [
    ...new Set(problems.map((problem) => problem.problemType)),
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
  var count = 0;
  useEffect(() => {
    problems.forEach((problem) => {
      getUserProblemById(problem.id)
        .then((response) => {
          setCountAllProblems(count + 1);
          setIsSolved((previous) => ({
            ...previous,
            [problem.id]: response.data,
          }));
        })
        .catch((error) => {
          console.log(error);
        });
    });
  }, [userId]); //THIS MUST TAKE THE USER ID TO WORK DONT TOUCH THE USER ID IN HERE

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
        <ProblemTypesComponent
          problemTypes={problemTypes}
          typeCount={typeCount}
        ></ProblemTypesComponent>
        <div className="filterContainer">
          <button
            className="openFilterButton tooltip-container"
            onClick={() => setOpenFilterBool(!openFilterBool)}
          >
            <svg
              version="1.1"
              xmlns="http://www.w3.org/2000/svg"
              width="25px"
              height="25px"
              viewBox="0 0 539.000000 463.000000"
            >
              <path
                d="M18.41,19.5c.83-.01,1.67-.01,2.53-.02c2.81-.02,5.61,0,8.42,.01c2.03,0,4.06-.01,6.09-.02c5.58-.01,11.17-.01,16.75,.01c6.02,.01,12.04-.01,18.07-.02c11.11-.02,22.22-.01,33.34,0c10.26,.01,20.53,.01,30.8,0c.34,0,.34,0,2.06,0c2.77,0,5.53,0,8.29,0c25.93-.01,51.86,0,77.79,.02c23.04,.02,46.08,.02,69.12,0c25.88-.02,51.76-.03,77.65-.02c2.75,0,5.51,0,8.27,0c.68,.01,1.36,.01,2.06,.01c10.26,0,20.52-.01,30.78-.02c11.67-.01,23.34,0,35,.02c5.96,.01,11.91,.01,17.87,0c5.44-.01,10.89-.01,16.34,.02c1.97,0,3.95,0,5.92-.01c2.68-.01,5.36,0,8.03,.02c.78-.01,1.55-.02,2.34-.03c5.17,.07,8.08,1.29,12.07,4.53c3.34,3.6,4.33,6.52,4.63,11.31c-.29,6.36-2.64,9.9-6.63,14.69c-.84,1.01-1.67,2.02-2.53,3.06c-1.87,2.24-3.76,4.46-5.67,6.67c-4.03,4.68-7.91,9.48-11.8,14.27c-3,3.67-6,7.34-9,11c-.52,.64-1.05,1.27-1.58,1.93c-6.05,7.38-12.11,14.74-18.29,22.01c-3.7,4.35-7.31,8.76-10.86,13.23c-4.74,5.92-9.6,11.74-14.42,17.59c-2.38,2.88-4.74,5.75-7.11,8.63c-1.16,1.41-2.32,2.82-3.48,4.22c-2.96,3.59-5.91,7.19-8.87,10.78c-5.38,6.55-10.77,13.09-16.26,19.55c-3.7,4.35-7.31,8.76-10.86,13.23c-4.74,5.92-9.6,11.74-14.42,17.59c-2.38,2.88-4.74,5.75-7.11,8.63c-1.16,1.41-2.32,2.82-3.48,4.22c-2.96,3.59-5.91,7.19-8.87,10.78c-1.19,1.45-2.38,2.91-3.58,4.36c-.58,.7-1.15,1.41-1.75,2.13c-4.49,5.46-9.05,10.84-13.66,16.19c-.79,.97-1.58,1.93-2.4,2.93c-.86,.9-1.72,1.8-2.61,2.73c-3.99,5.69-3.07,12.81-3,19.46c-.01,1.54-.01,3.09-.02,4.64c-.01,3.32-.01,6.64,.01,9.96c.02,5.25,.01,10.5-.01,15.76c-.02,9.25-.01,18.51,0,27.77c.02,13.93,.01,27.86-.02,41.8c-.01,5.22-.01,10.44,.01,15.66c.01,3.25,0,6.5-.01,9.74c0,1.51,.01,3.01,.02,4.51c.1,15.96,.1,15.96-4.85,21.68c-7.04,5.03-14.84,8.68-22.58,12.48c-1.55,.76-3.1,1.53-4.65,2.3c-8.86,4.38-17.76,8.68-26.7,12.89c-13.06,6.2-25.94,12.77-38.85,19.27c-.95,.48-1.9,.95-2.87,1.44c-1.81,.91-3.61,1.81-5.41,2.72c-.81,.41-1.61,.81-2.45,1.23c-.7,.36-1.41,.71-2.13,1.08c-5.31,2.49-11.31,3-16.95,1.23c-4.57-2.31-7.06-5.71-8.93-10.35c-.52-2.94-.51-5.8-.47-8.78c0-.87,0-1.73,0-2.61c0-2.87,.02-5.74,.05-8.62c.01-2.06,.01-4.12,.01-6.19c0-4.43,.02-8.87,.05-13.31c.04-7.02,.04-14.05,.04-21.07c0-19.97,.05-39.93,.13-59.9c.05-11.03,.06-22.07,.05-33.1c-.01-6.97,.02-13.95,.08-20.93c.02-4.34,.01-8.69,0-13.04c0-2.01,.01-4.02,.04-6.03c.22-17.05,.22-17.05-4.86-23.48c-1.34-1.35-2.71-2.66-4.12-3.94c-.99-1.14-1.96-2.3-2.91-3.47c-.85-1-1.71-2-2.59-3.03c-3.83-4.49-7.56-9.04-11.23-13.67c-4.74-5.91-9.59-11.73-14.41-17.57c-1.83-2.23-3.66-4.45-5.49-6.68c-5.37-6.54-10.76-13.07-16.24-19.52c-3.7-4.35-7.31-8.76-10.86-13.23c-4.74-5.91-9.59-11.73-14.41-17.57c-1.83-2.23-3.66-4.45-5.49-6.68c-5.37-6.54-10.76-13.07-16.24-19.52c-3.7-4.35-7.31-8.76-10.86-13.23c-4.74-5.91-9.59-11.73-14.41-17.57c-1.83-2.23-3.66-4.45-5.49-6.68C43,95.04,37.61,88.51,32.13,82.06c-3.69-4.33-7.3-8.73-10.83-13.19c-1.88-2.35-3.8-4.67-5.73-6.99c-.31-.37-.31-.37-1.87-2.24c-1.23-1.47-2.46-2.94-3.69-4.4C-.91,42.13-.91,42.13-.42,32.55c.82-5.01,3.21-7.57,7.04-10.68c4.04-2.24,7.29-2.43,11.79-2.37ZM50,52c3.79,5.06,7.54,9.9,11.69,14.63c4.05,4.67,7.97,9.41,11.75,14.31c4.45,5.75,9.14,11.26,13.94,16.74c3.58,4.1,7.05,8.28,10.42,12.56c2.9,3.64,5.86,7.23,8.83,10.82c.6,.73,1.2,1.46,1.82,2.21c1.23,1.5,2.47,2.99,3.7,4.49c2.38,2.88,4.74,5.75,7.11,8.63c1.16,1.41,2.32,2.82,3.48,4.22c2.96,3.59,5.91,7.19,8.87,10.78c5.38,6.55,10.77,13.09,16.27,19.55c3.69,4.35,7.3,8.76,10.85,13.23c4.74,5.91,9.59,11.73,14.41,17.57c1.83,2.23,3.66,4.45,5.49,6.68c5.37,6.54,10.76,13.07,16.25,19.52c3.81,4.49,7.56,9.03,11.21,13.65c1.33,1.69,2.7,3.35,4.07,5c.71,.86,1.42,1.72,2.15,2.6c.64,.75,1.27,1.51,1.93,2.29c3.99,5.71,5.21,10.64,5.16,17.54c0,.39,0,.39,.02,2.35c.02,2.59,.01,5.18,.01,7.77c.01,1.87,.02,3.73,.03,5.59c.03,5.05,.04,10.1,.05,15.14c.01,5.28,.03,10.56,.06,15.84c.04,9.99,.07,19.98,.09,29.97c.03,11.38,.07,22.75,.12,34.13c.09,23.4,.16,46.79,.22,70.19c3.83-1.25,7.42-2.58,11.02-4.4c.47-.23,.47-.23,2.87-1.43c1.02-.51,2.03-1.03,3.07-1.55c1.06-.54,2.13-1.07,3.22-1.62c3.4-1.7,6.8-3.41,10.2-5.12c2.24-1.13,4.49-2.26,6.73-3.39c4.2-2.1,8.39-4.21,12.58-6.32c7.43-3.74,14.87-7.45,22.31-11.17c0-.39,0-.39,.01-2.39c.06-19.16,.13-38.32,.23-57.48c.04-9.27,.08-18.54,.11-27.81c.02-8.07,.05-16.15,.1-24.23c.02-4.28,.04-8.55,.05-12.83c0-4.03,.02-8.05,.05-12.08c.01-1.48,.02-2.95,.02-4.43c-.01-11.24,.98-17.55,8.62-26.06c.99-1.14,1.99-2.29,2.98-3.43c.48-.55,.97-1.11,1.47-1.68c1.85-2.15,3.61-4.36,5.36-6.58c3.09-3.9,6.27-7.71,9.5-11.5c3.83-4.49,7.56-9.04,11.23-13.67c4.74-5.91,9.59-11.73,14.41-17.57c1.83-2.23,3.66-4.45,5.49-6.68c5.37-6.54,10.76-13.07,16.25-19.52c3.69-4.35,7.3-8.76,10.85-13.23c4.74-5.92,9.6-11.74,14.42-17.59c2.38-2.88,4.74-5.75,7.11-8.63c1.16-1.41,2.32-2.82,3.48-4.22c2.96-3.59,5.91-7.19,8.87-10.78c5.38-6.55,10.77-13.09,16.27-19.55c3.68-4.33,7.28-8.73,10.82-13.19c3.68-4.59,7.44-9.11,11.2-13.63c.29-.35,.29-.35,1.73-2.09c.51-.61,1.01-1.21,1.53-1.84c2.69-3.38,5.25-6.86,7.84-10.31c-137.33,0-274.67,0-412,0Z"
                fill="var(--text-primary-color)"
              />
            </svg>
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
          <div className="solvedOutOfTotal">Solved: {countAllProblems}</div>
        </div>
        <ol className="listOfProblems">{listOfProblems}</ol>
      </div>
      <BackToTopButton></BackToTopButton>
    </>
  );
};
export default ListProblems;
