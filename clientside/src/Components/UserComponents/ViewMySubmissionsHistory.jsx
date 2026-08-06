import { useEffect, useState } from "react";
import "../../App.css";
import arrowback from "../../assets/arrowback_2_10.png";
import arrowDown from "../../assets/arrowDown.png";
import arrowfront from "../../assets/arrowfront_10.png";
import img from "../../assets/arrows.png";
import arrowUp from "../../assets/arrowUpS.png";
import { getAllUserSubmissions } from "../../services/SubmitService";
import ProblemDifficulty from "../ProblemDifficulty";
import "./ViewMySubmissions.css";
const ViewMySumbissionsHistory = (props) => {
  const [mySubmissions, setMySubmissions] = useState([]);
  const userId = props.userId;
  const [count, setCount] = useState(0);
  const [pageNumber, setPageNumber] = useState(1);
  const [pageSize, setPageSize] = useState(10);
  const [sortBy, setSortBy] = useState("");
  const [sortDir, setSortDir] = useState("DESC");
  const [totalPages, setTotalPages] = useState(0);
  const pageNumbers = [];

  const getAllSubmissions = () => {
    console.log(pageNumber);
    getAllUserSubmissions(userId, pageNumber, pageSize, sortDir)
      .then((response) => {
        setMySubmissions(response.data.content);
        setCount(response.data.totalElements);
        setTotalPages(response.data.totalPages);
        console.log(
          "console log from submission history",
          response.data.content,
        );
      })
      .catch((error) => {
        console.log(error);
      });
  };
  useEffect(() => {
    if (userId) {
      getAllSubmissions();
    }
  }, [userId, pageNumber, pageSize, sortDir]);

  const listOfMySubmissions = mySubmissions.map((submission) => (
    <div key={submission.id} className="submissionItem">
      <div className="numberTitleAndDifficulty">
        {submission.number}. {submission.title}
        <div className="difficultyDivSubmission">
          <ProblemDifficulty
            difficulty={submission.difficulty}
          ></ProblemDifficulty>
        </div>
      </div>
      <div>{submission.date}</div>
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
          <div className="submissionsContainer">
            <div className="imageAndText">
              <div className="plainText">
                <h1 className="submissionsHeader">
                  <img src={img} alt={img} className="image"></img>
                  <div className="headerText">Submission History</div>
                </h1>

                <div className="submissionsCounter">
                  <div className="textDiv">
                    Submissions Sent:
                    <div className="submissionsCount">
                      {count}
                      <div className="submissionsSupperText">Submissions</div>
                    </div>
                  </div>
                  <div className="filtersAndSorts">
                    <button
                      className="sortDir"
                      onClick={() =>
                        sortDir === "DESC"
                          ? setSortDir("ASC")
                          : setSortDir("DESC")
                      }
                    >
                      <img
                        className="arrowSortImg"
                        src={sortDir === "DESC" ? arrowDown : arrowUp}
                        alt={arrowDown}
                      />
                    </button>
                  </div>
                </div>
              </div>
            </div>

            <ol className="listOfUserSubmissions">{listOfMySubmissions}</ol>
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
          <h1 className="userProblemsHeader">Submission History</h1>
          <div className="userProblemsCounter">Total Submissions: {count}</div>
          <img src={img} alt={img} className="countZeroImage"></img>
          <p className="noProblems">No Submissions Yet</p>
        </>
      )}
    </>
  );
};
export default ViewMySumbissionsHistory;
