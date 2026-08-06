import { useEffect, useState } from "react";
import "../../App.css";
import arrowback from "../../assets/arrowback_2_10.png";
import arrowfront from "../../assets/arrowfront_10.png";
import img2 from "../../assets/list.png";
import { getProblemsCount } from "../../services/ProblemService";
import { getUserProblems } from "../../services/UserProblemService";
import ProblemDifficulty from "../ProblemDifficulty";
import "./ViewMyProblems.css";
const ViewMyProblems = (props) => {
  const [myProblems, setMyProblems] = useState([]);
  const [countOfAllProblems, setCountOfAllProblems] = useState("");
  const [count, setCount] = useState(0);
  const [pageNumber, setPageNumber] = useState(1);
  const [pageSize, setPageSize] = useState(10);
  const [totalPages, setTotalPages] = useState(0);
  const pageNumbers = [];

  const userId = props.userId;
  console.log(userId);
  const getAllUserProblems = () => {
    getUserProblems(userId, pageNumber, pageSize)
      .then((response) => {
        setMyProblems(response.data.content);
        setCount(response.data.totalElements);
        setTotalPages(response.data.totalPages);
        console.log("Api response:", response.data.content);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  useEffect(() => {
    if (userId) {
      getAllUserProblems();
    }
  }, [userId, pageNumber, pageSize]);

  useEffect(() => {
    getProblemsCount()
      .then((response) => {
        setCountOfAllProblems(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const listOfMyProblems = myProblems.map((myProblem) => (
    <div key={myProblem.problemId} className="userProblem">
      <div>
        {myProblem.number}. {myProblem.title}
      </div>
      <div>
        <ProblemDifficulty
          difficulty={myProblem.difficulty}
        ></ProblemDifficulty>
      </div>
    </div>
  ));

  for (let i = 1; i <= totalPages; i++) {
    pageNumbers.push(i);
  }

  const pageNumberButtons = pageNumbers.map((number) => (
    <button
      key={number}
      onClick={() => setPageNumber(number)}
      className={`buttonNumberPage ${pageNumber === number ? "active" : ""}`}
    >
      {number}
    </button>
  ));

  return (
    <>
      {count > 0 ? (
        <>
          <div className="problemsContainer">
            <div className="imageAndText">
              <div className="plainText">
                <h1 className="userProblemsHeader">
                  <img src={img2} alt={img2} className="image"></img>
                  <div className="headerText">Solved Problems</div>
                </h1>
                <div className="userProblemsCounter">
                  Total Solved:
                  <div className="solvedCounter">
                    {count}/{countOfAllProblems}
                    <div className="problemsSupperText">Problems</div>
                  </div>
                </div>
              </div>
            </div>
            <ol className="listOfUserProblems">{listOfMyProblems}</ol>
          </div>
          <div className="pageButtonsContainer">
            <button
              className="pageButton"
              onClick={() => setPageNumber((page) => Math.max(page - 1, 0))}
              disabled={pageNumber === 1}
            >
              <img src={arrowback} alt={arrowback}></img>
            </button>
            {pageNumberButtons}
            <button
              className="pageButton"
              onClick={() =>
                setPageNumber((page) => Math.max(page, totalPages))
              }
              disabled={pageNumber === totalPages}
            >
              <img src={arrowfront} alt={arrowfront}></img>
            </button>
          </div>
        </>
      ) : (
        <>
          <h1 className="userProblemsHeader">Solved Problems</h1>
          <div className="userProblemsCounter">{count} Problems solved</div>
          <img src={img2} alt={img2} className="countZeroImage"></img>
          <p className="noProblems">No Problems Solved Yet</p>
        </>
      )}
    </>
  );
};

export default ViewMyProblems;
