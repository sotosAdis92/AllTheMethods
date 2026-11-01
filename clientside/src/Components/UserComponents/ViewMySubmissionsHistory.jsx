import { useEffect, useState } from "react";
import "../../App.css";
import arrowback from "../../assets/arrowback_2_10.png";
import arrowDown from "../../assets/arrowDown.png";
import arrowfront from "../../assets/arrowfront_10.png";
import arrowUp from "../../assets/arrowUpS.png";
import { getAllUserSubmissions } from "../../services/SubmitService";
import ProblemDifficulty from "../ProblemDifficulty/ProblemDifficulty";
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
    getAllUserSubmissions(userId, pageNumber, pageSize, sortDir)
      .then((response) => {
        setMySubmissions(response.data.content);
        setCount(response.data.totalElements);
        setTotalPages(response.data.totalPages);
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
                  <svg
                    version="1.0"
                    xmlns="http://www.w3.org/2000/svg"
                    width="27px"
                    height="27px"
                    viewBox="0 0 447.000000 447.000000"
                    preserveAspectRatio="xMidYMid meet"
                    className="image"
                  >
                    <g
                      transform="translate(0.000000,447.000000) scale(0.100000,-0.100000)"
                      fill="var(--text-primary-color)"
                      stroke="none"
                    >
                      <path
                        d="M1345 3927 c-28 -13 -390 -353 -657 -617 -110 -109 -117 -118 -127
-170 -9 -45 -8 -65 4 -107 14 -48 38 -73 381 -410 201 -197 377 -364 391 -372
17 -8 44 -11 76 -8 43 4 56 10 85 42 33 35 34 40 30 98 l-5 61 -246 242 c-136
133 -247 245 -247 248 0 3 563 6 1250 6 1381 0 1289 -4 1330 63 25 41 25 87 1
135 -36 72 60 66 -1350 72 l-1273 5 260 249 c143 137 265 260 271 273 15 34
14 99 -3 132 -29 56 -113 84 -171 58z"
                      />
                      <path
                        d="M2874 2220 c-12 -5 -34 -24 -49 -44 -34 -45 -37 -112 -6 -155 11 -16
124 -130 251 -254 126 -123 230 -227 230 -231 0 -3 -532 -6 -1182 -6 -1169 0
-1183 0 -1216 -20 -35 -21 -62 -72 -62 -115 0 -44 35 -99 74 -118 34 -16 119
-17 1234 -17 l1197 0 -100 -98 c-55 -53 -174 -168 -263 -254 -124 -118 -167
-166 -177 -196 -36 -103 65 -207 167 -173 39 13 31 6 436 394 177 170 331 324
343 343 31 51 30 152 -4 203 -28 42 -716 719 -750 738 -25 14 -92 16 -123 3z"
                      />
                    </g>
                  </svg>
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
          {totalPages > 1 ? (
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
          ) : (
            <div></div>
          )}
        </>
      ) : (
        <>
          <h1 className="userProblemsHeader">Submission History</h1>
          <div className="userProblemsCounter">Total Submissions: {count}</div>
          <svg
            version="1.0"
            xmlns="http://www.w3.org/2000/svg"
            width="300px"
            height="300px"
            viewBox="0 0 447.000000 447.000000"
            preserveAspectRatio="xMidYMid meet"
            className="countZeroImage"
          >
            <g
              transform="translate(0.000000,447.000000) scale(0.100000,-0.100000)"
              fill="var(--text-primary-color)"
              stroke="none"
            >
              <path
                d="M1345 3927 c-28 -13 -390 -353 -657 -617 -110 -109 -117 -118 -127
-170 -9 -45 -8 -65 4 -107 14 -48 38 -73 381 -410 201 -197 377 -364 391 -372
17 -8 44 -11 76 -8 43 4 56 10 85 42 33 35 34 40 30 98 l-5 61 -246 242 c-136
133 -247 245 -247 248 0 3 563 6 1250 6 1381 0 1289 -4 1330 63 25 41 25 87 1
135 -36 72 60 66 -1350 72 l-1273 5 260 249 c143 137 265 260 271 273 15 34
14 99 -3 132 -29 56 -113 84 -171 58z"
              />
              <path
                d="M2874 2220 c-12 -5 -34 -24 -49 -44 -34 -45 -37 -112 -6 -155 11 -16
124 -130 251 -254 126 -123 230 -227 230 -231 0 -3 -532 -6 -1182 -6 -1169 0
-1183 0 -1216 -20 -35 -21 -62 -72 -62 -115 0 -44 35 -99 74 -118 34 -16 119
-17 1234 -17 l1197 0 -100 -98 c-55 -53 -174 -168 -263 -254 -124 -118 -167
-166 -177 -196 -36 -103 65 -207 167 -173 39 13 31 6 436 394 177 170 331 324
343 343 31 51 30 152 -4 203 -28 42 -716 719 -750 738 -25 14 -92 16 -123 3z"
              />
            </g>
          </svg>
          <p className="noProblems">No Submissions Yet</p>
        </>
      )}
    </>
  );
};
export default ViewMySumbissionsHistory;
