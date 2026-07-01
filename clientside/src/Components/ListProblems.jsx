import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import img from "../assets/check.png";
import { listProblems } from "../services/ProblemService";
import { getUserProblemById } from "../services/UserProblemService";
import ProblemDifficulty from "./ProblemDifficulty";
const ListProblems = () => {
  const [problems, setProblems] = useState([]);
  const [isSolved, setIsSolved] = useState({});
  const navigator = useNavigate();
  function getAllProblems() {
    listProblems()
      .then((response) => {
        setProblems(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }
  useEffect(() => {
    getAllProblems();
  }, []);

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
      <h2 className="problemsTitle">List Of Problems</h2>
      <ol>{listOfProblems}</ol>
    </>
  );
};
export default ListProblems;
