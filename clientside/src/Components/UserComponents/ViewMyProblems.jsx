import { useEffect, useState } from "react";
import "../../App.css";
import arrowback from "../../assets/arrowback_2_10.png";
import arrowfront from "../../assets/arrowfront_10.png";
import { getProblemsCount } from "../../services/ProblemService";
import { getUserProblems } from "../../services/UserProblemService";
import ProblemDifficulty from "../ProblemDifficulty/ProblemDifficulty";
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

  const getAllUserProblems = () => {
    getUserProblems(userId, pageNumber, pageSize)
      .then((response) => {
        setMyProblems(response.data.content);
        setCount(response.data.totalElements);
        setTotalPages(response.data.totalPages);
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
                  <svg
                    version="1.0"
                    xmlns="http://www.w3.org/2000/svg"
                    width="30px"
                    height="30px"
                    viewBox="0 0 512.000000 512.000000"
                    preserveAspectRatio="xMidYMid meet"
                  >
                    <g
                      transform="translate(0.000000,512.000000) scale(0.100000,-0.100000)"
                      fill="var(--text-primary-color)"
                      stroke="none"
                    >
                      <path
                        d="M2230 5102 c-82 -22 -146 -59 -208 -122 -67 -67 -96 -131 -140 -305
l-39 -150 -139 -6 c-76 -4 -153 -11 -169 -16 -113 -37 -216 -121 -266 -218
l-34 -65 -101 0 c-56 0 -125 -5 -155 -10 -180 -34 -325 -179 -359 -359 -14
-74 -14 -3408 0 -3482 34 -180 179 -325 359 -359 74 -14 3088 -14 3162 0 160
31 287 142 349 305 13 35 15 258 17 1759 2 1141 0 1738 -7 1775 -33 181 -178
327 -359 361 -30 5 -99 10 -155 10 l-101 0 -34 65 c-50 97 -153 181 -266 218
-16 5 -93 12 -169 16 l-139 6 -38 148 c-45 175 -76 241 -145 311 -63 63 -130
101 -215 121 -97 22 -559 20 -649 -3z m610 -300 c56 -28 74 -68 126 -279 74
-300 70 -296 342 -303 224 -6 247 -12 282 -80 16 -31 20 -59 20 -130 l0 -90
-1050 0 -1050 0 0 90 c0 71 4 99 20 130 35 68 58 74 282 80 272 7 268 3 342
303 75 307 62 297 406 297 213 0 250 -2 280 -18z m-1630 -972 c0 -112 20 -159
80 -190 39 -20 56 -20 1270 -20 1214 0 1231 0 1270 20 60 31 80 78 80 190 l0
90 90 0 c112 0 159 -20 190 -80 20 -39 20 -55 20 -1732 0 -1630 -1 -1695 -19
-1728 -10 -19 -36 -45 -57 -57 l-39 -23 -1533 0 c-1517 0 -1533 0 -1572 20
-26 13 -47 34 -60 60 -20 39 -20 55 -20 1730 0 1674 0 1691 20 1730 31 60 75
79 188 80 l92 0 0 -90z"
                      />
                      <path
                        d="M2488 4499 c-43 -22 -78 -81 -78 -129 0 -50 35 -107 80 -130 21 -11
53 -20 70 -20 76 0 150 74 150 150 0 50 -35 107 -80 130 -49 25 -94 25 -142
-1z"
                      />
                      <path
                        d="M2190 3289 c-19 -11 -146 -132 -282 -267 l-247 -246 -103 100 c-110
108 -148 134 -199 134 -72 0 -149 -77 -149 -149 0 -54 27 -90 179 -245 212
-216 257 -238 352 -177 57 37 632 616 653 658 34 68 6 153 -64 192 -48 27 -95
27 -140 0z"
                      />
                      <path
                        d="M2788 2989 c-43 -22 -78 -81 -78 -129 0 -50 35 -107 80 -130 38 -19
58 -20 520 -20 462 0 482 1 520 20 45 23 80 80 80 130 0 50 -35 107 -80 130
-38 19 -57 20 -522 20 -461 -1 -485 -2 -520 -21z"
                      />
                      <path
                        d="M2190 2389 c-19 -11 -146 -132 -282 -267 l-247 -246 -103 100 c-110
108 -148 134 -199 134 -72 0 -149 -77 -149 -149 0 -54 27 -90 179 -245 212
-216 257 -238 352 -177 57 37 632 616 653 658 34 68 6 153 -64 192 -48 27 -95
27 -140 0z"
                      />
                      <path
                        d="M2788 2089 c-43 -22 -78 -81 -78 -129 0 -50 35 -107 80 -130 38 -19
58 -20 520 -20 462 0 482 1 520 20 45 23 80 80 80 130 0 50 -35 107 -80 130
-38 19 -57 20 -522 20 -461 -1 -485 -2 -520 -21z"
                      />
                      <path
                        d="M2190 1489 c-19 -11 -146 -132 -282 -267 l-247 -246 -103 100 c-110
108 -148 134 -199 134 -72 0 -149 -77 -149 -149 0 -54 27 -90 179 -245 212
-216 257 -238 352 -177 57 37 632 616 653 658 34 68 6 153 -64 192 -48 27 -95
27 -140 0z"
                      />
                      <path
                        d="M2788 1189 c-43 -22 -78 -81 -78 -129 0 -50 35 -107 80 -130 38 -19
58 -20 520 -20 462 0 482 1 520 20 45 23 80 80 80 130 0 50 -35 107 -80 130
-38 19 -57 20 -522 20 -461 -1 -485 -2 -520 -21z"
                      />
                    </g>
                  </svg>
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
          <h1 className="userProblemsHeader">Solved Problems</h1>
          <div className="userProblemsCounter">{count} Problems solved</div>
          <svg
            version="1.0"
            xmlns="http://www.w3.org/2000/svg"
            width="30px"
            height="30px"
            viewBox="0 0 512.000000 512.000000"
            preserveAspectRatio="xMidYMid meet"
            className="countZeroImage"
          >
            <g
              transform="translate(0.000000,512.000000) scale(0.100000,-0.100000)"
              fill="var(--text-primary-color)"
              stroke="none"
            >
              <path
                d="M2230 5102 c-82 -22 -146 -59 -208 -122 -67 -67 -96 -131 -140 -305
l-39 -150 -139 -6 c-76 -4 -153 -11 -169 -16 -113 -37 -216 -121 -266 -218
l-34 -65 -101 0 c-56 0 -125 -5 -155 -10 -180 -34 -325 -179 -359 -359 -14
-74 -14 -3408 0 -3482 34 -180 179 -325 359 -359 74 -14 3088 -14 3162 0 160
31 287 142 349 305 13 35 15 258 17 1759 2 1141 0 1738 -7 1775 -33 181 -178
327 -359 361 -30 5 -99 10 -155 10 l-101 0 -34 65 c-50 97 -153 181 -266 218
-16 5 -93 12 -169 16 l-139 6 -38 148 c-45 175 -76 241 -145 311 -63 63 -130
101 -215 121 -97 22 -559 20 -649 -3z m610 -300 c56 -28 74 -68 126 -279 74
-300 70 -296 342 -303 224 -6 247 -12 282 -80 16 -31 20 -59 20 -130 l0 -90
-1050 0 -1050 0 0 90 c0 71 4 99 20 130 35 68 58 74 282 80 272 7 268 3 342
303 75 307 62 297 406 297 213 0 250 -2 280 -18z m-1630 -972 c0 -112 20 -159
80 -190 39 -20 56 -20 1270 -20 1214 0 1231 0 1270 20 60 31 80 78 80 190 l0
90 90 0 c112 0 159 -20 190 -80 20 -39 20 -55 20 -1732 0 -1630 -1 -1695 -19
-1728 -10 -19 -36 -45 -57 -57 l-39 -23 -1533 0 c-1517 0 -1533 0 -1572 20
-26 13 -47 34 -60 60 -20 39 -20 55 -20 1730 0 1674 0 1691 20 1730 31 60 75
79 188 80 l92 0 0 -90z"
              />
              <path
                d="M2488 4499 c-43 -22 -78 -81 -78 -129 0 -50 35 -107 80 -130 21 -11
53 -20 70 -20 76 0 150 74 150 150 0 50 -35 107 -80 130 -49 25 -94 25 -142
-1z"
              />
              <path
                d="M2190 3289 c-19 -11 -146 -132 -282 -267 l-247 -246 -103 100 c-110
108 -148 134 -199 134 -72 0 -149 -77 -149 -149 0 -54 27 -90 179 -245 212
-216 257 -238 352 -177 57 37 632 616 653 658 34 68 6 153 -64 192 -48 27 -95
27 -140 0z"
              />
              <path
                d="M2788 2989 c-43 -22 -78 -81 -78 -129 0 -50 35 -107 80 -130 38 -19
58 -20 520 -20 462 0 482 1 520 20 45 23 80 80 80 130 0 50 -35 107 -80 130
-38 19 -57 20 -522 20 -461 -1 -485 -2 -520 -21z"
              />
              <path
                d="M2190 2389 c-19 -11 -146 -132 -282 -267 l-247 -246 -103 100 c-110
108 -148 134 -199 134 -72 0 -149 -77 -149 -149 0 -54 27 -90 179 -245 212
-216 257 -238 352 -177 57 37 632 616 653 658 34 68 6 153 -64 192 -48 27 -95
27 -140 0z"
              />
              <path
                d="M2788 2089 c-43 -22 -78 -81 -78 -129 0 -50 35 -107 80 -130 38 -19
58 -20 520 -20 462 0 482 1 520 20 45 23 80 80 80 130 0 50 -35 107 -80 130
-38 19 -57 20 -522 20 -461 -1 -485 -2 -520 -21z"
              />
              <path
                d="M2190 1489 c-19 -11 -146 -132 -282 -267 l-247 -246 -103 100 c-110
108 -148 134 -199 134 -72 0 -149 -77 -149 -149 0 -54 27 -90 179 -245 212
-216 257 -238 352 -177 57 37 632 616 653 658 34 68 6 153 -64 192 -48 27 -95
27 -140 0z"
              />
              <path
                d="M2788 1189 c-43 -22 -78 -81 -78 -129 0 -50 35 -107 80 -130 38 -19
58 -20 520 -20 462 0 482 1 520 20 45 23 80 80 80 130 0 50 -35 107 -80 130
-38 19 -57 20 -522 20 -461 -1 -485 -2 -520 -21z"
              />
            </g>
          </svg>
          <p className="noProblems">No Problems Solved Yet</p>
        </>
      )}
    </>
  );
};

export default ViewMyProblems;
