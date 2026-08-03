import { useEffect, useState } from "react";
import "../../App.css";
import img from "../../assets/arrows.png";
import { getAllUserSubmissions } from "../../services/SubmitService";
import "./ViewMySubmissions.css";
const ViewMySumbissionsHistory = (props) => {
  const [mySubmissions, setMySubmissions] = useState([]);
  const userId = props.userId;
  const [count, setCount] = useState(0);
  const [pageNumber, setPageNumber] = useState(1);
  const [pageSize, setPageSize] = useState(10);
  const [totalPages, setTotalPages] = useState(0);
  const pageNumbers = [];
  const getAllSubmissions = () => {
    console.log(pageNumber);
    getAllUserSubmissions(userId, pageNumber, pageSize)
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
  }, [userId, pageNumber, pageSize]);

  const listOfMySubmissions = mySubmissions.map((submission) => (
    <div key={submission.id} className="submissionItem">
      <div>
        {submission.number}. {submission.title}
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
                  Submissions Sent:
                  <div className="submissionsCount">
                    {count}
                    <div className="submissionsSupperText">Submissions</div>
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
              Back
              <img src="" alt=""></img>
            </button>
            {pageNumberButtons}
            <button
              className="pageButton"
              onClick={() =>
                setPageNumber((page) => Math.max(page, totalPages))
              }
              disabled={pageNumber === totalPages}
            >
              Front
              <img src="" alt=""></img>
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
