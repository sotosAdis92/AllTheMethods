import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import img2 from "../assets/5110770.png";
import img from "../assets/check.png";
import img3 from "../assets/filter.png";
import {
  getProblemsByCategory,
  getProblemsByDifficulty,
  listProblems,
} from "../services/ProblemService";
import { getUserProblemById } from "../services/UserProblemService";
import AchievementImage from "./AchievementImage";
import ProblemDifficulty from "./ProblemDifficulty";
const ListProblems = () => {
  const [problems, setProblems] = useState([]);
  const [isSolved, setIsSolved] = useState({});
  const [problemCategoryFilters, setProblemCategoryFilters] = useState([]);
  const [problemDifficultyFilters, setProblemDifficultyFilters] = useState([]);
  const [openFilterBool, setOpenFilterBool] = useState(false);

  const navigator = useNavigate();
  function getAllProblems() {
    listProblems()
      .then((response) => {
        setProblems(response.data);
        setProblemCategoryFilters(response.data);
        setProblemDifficultyFilters(response.data);
        console.log(response.data);
        console.log(problemCategoryFilters);
      })
      .catch((error) => {
        console.error(error);
      });
  }
  useEffect(() => {
    getAllProblems();
  }, []);

  const categoryFilters = [
    ...new Set(problemCategoryFilters.map((problem) => problem.category)),
  ];

  const difficultyFilters = [
    ...new Set(problemDifficultyFilters.map((problem) => problem.difficulty)),
  ];

  const handleClickCategoryFilterProblems = (value) => {
    getProblemsByCategory(value).then((response) => setProblems(response.data));
  };

  const handleClickDifficultyFilterProblems = (value) => {
    getProblemsByDifficulty(value).then((response) =>
      setProblems(response.data),
    );
  };

  const listOfCategoryFilters = categoryFilters.map((filter, i) => (
    <div key={i}>
      <button
        onClick={() => handleClickCategoryFilterProblems(filter)}
        className="filters"
      >
        <div className="filterImage">
          <AchievementImage category={filter}></AchievementImage>
        </div>
        {filter}
      </button>
    </div>
  ));

  const listOfDifficultyFilter = difficultyFilters.map((filter, i) => (
    <div key={i}>
      <button
        onClick={() => handleClickDifficultyFilterProblems(filter)}
        className="filters"
      >
        <ProblemDifficulty difficulty={filter}></ProblemDifficulty>
      </button>
    </div>
  ));

  function navigate(problemId) {
    navigator("problems/" + problemId);
  }

  useEffect(() => {
    for (let i = 0; i < problems.length; i++) {
      getUserProblemById(problems[i].problemId)
        .then((response) => {
          setIsSolved((previous) => ({
            ...previous,
            [problems[i].problemId]: response.data,
          }));
        })
        .catch((error) => {
          console.log(error);
        });
    }
  }, [problems]);

  const listOfProblems = problems
    .sort(function (a, b) {
      return a.number - b.number;
    })
    .map((problem, i) => (
      <div className="problemWithButtons">
        <div
          key={problem.problemId}
          className={i % 2 !== 0 ? "problemOdd" : "problemItem"}
          onClick={() => navigate(problem.problemId)}
        >
          <a className="problemLink">
            <div className="problemDetails">
              {problem.number}. {problem.title}
              <ProblemDifficulty
                difficulty={problem.difficulty}
              ></ProblemDifficulty>
              {problem.points}pts.
              {isSolved[problem.problemId] ? (
                <div className="checkmark">
                  <img src={img}></img>
                </div>
              ) : (
                <div></div>
              )}
            </div>
          </a>
        </div>
      </div>
    ));

  return (
    <>
      <div className="problemScreen">
        <h2 className="problemsTitle">List Of Problems</h2>
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
              <button onClick={() => getAllProblems()} className="filterButton">
                <img src={img2} className="allAchFilterImg"></img>
                All Problems
              </button>
              <div>
                <h3 className="categoryHeading">Is of Category:</h3>
                <ol className="filterCategories">{listOfCategoryFilters}</ol>
              </div>
              <div>
                <h3 className="categoryHeading">Is of Difficulty:</h3>
                <ol className="filterCategories">{listOfDifficultyFilter}</ol>
              </div>
            </div>
          )}
        </div>
        <ol className="listOfProblems">{listOfProblems}</ol>
      </div>
    </>
  );
};
export default ListProblems;
