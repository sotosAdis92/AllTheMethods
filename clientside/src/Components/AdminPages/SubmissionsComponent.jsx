import { useEffect, useState } from "react";
import arrowback from "../../assets/arrowback_2_10.png";
import arrowfront from "../../assets/arrowfront_10.png";
import { getAllSubmissions } from "../../services/SubmitService";
import "./SubmissionComponent.css";
const SubmissionComponent = () => {
  const [submissions, setSubmissions] = useState([]);
  const [count, setCount] = useState(0);
  const [pageNumber, setPageNumber] = useState(1);
  const [pageSize, setPageSize] = useState(30);
  const [sortBy, setSortBy] = useState("");
  const [sortDir, setSortDir] = useState("DESC");
  const [totalPages, setTotalPages] = useState(0);
  const pageNumbers = [];

  useEffect(() => {
    getAllSubmissions().then((response) => {
      console.log(response.data);
      setSubmissions(response.data.content);
      setCount(response.data.numberOfElements);
      setTotalPages(response.data.totalPages);
    });
  }, []);

  const listOfSubmissions = submissions.map((submission) => (
    <div className="submission-item" key={submission.id}>
      <div>Id: {submission.id}</div>
      <div>Date: {submission.date}</div>
      <div>Problem Title: {submission.title}</div>
      <div>Problem Number: {submission.number}</div>
      <div>Problem Difficulty: {submission.difficulty}</div>
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
    <div>
      <div>{listOfSubmissions}</div>
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
            onClick={() => setPageNumber((page) => Math.max(page, totalPages))}
            disabled={pageNumber === totalPages}
          >
            <img src={arrowfront} alt={arrowfront}></img>
          </button>
        </div>
      ) : (
        <div></div>
      )}
    </div>
  );
};
export default SubmissionComponent;
