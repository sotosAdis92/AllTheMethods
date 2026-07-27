import { useEffect, useState } from "react";
import "../../App.css";
import { getAllUserSubmissions } from "../../services/SubmitService";
import ProblemDifficulty from "../ProblemDifficulty";
import "./ViewMySubmissions.css";
const ViewMySumbissionsHistory = (props) => {
  const [mySubmissions, setMySubmissions] = useState([]);
  const userId = props.userId;
  const count = mySubmissions.filter((mySubmission) => mySubmission.id).length;
  const getAllSubmissions = () => {
    getAllUserSubmissions(userId)
      .then((response) => {
        setMySubmissions(response.data);
        console.log("console log from submission history", response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  useEffect(() => {
    if (userId) {
      getAllSubmissions();
    }
  }, [userId]);

  const listOfMySubmissions = mySubmissions.map((submission, i) => (
    <div key={submission.id} className="submissionItem">
      <div className="submissionDiv">
        {submission.number}. {submission.title}
      </div>
      <div className="submissionDiv">{submission.date}</div>
      <ProblemDifficulty difficulty={submission.difficulty}></ProblemDifficulty>
    </div>
  ));

  return (
    <>
      {count > 0 ? (
        <>
          <div className="submissionsContainer">
            <h1 className="submissionsHeader">Submission History</h1>
            <div className="submissionsCounter">Total Submissions: {count}</div>
            <ol className="listOfUserSubmissions">{listOfMySubmissions}</ol>
          </div>
        </>
      ) : (
        <>
          <h1 className="userProblemsHeader">Submission History</h1>
          <div className="userProblemsCounter">Total Submissions: {count}</div>
          <img className="countZeroImage"></img>
          <p className="noProblems">No Submissions Yet!!</p>
        </>
      )}
    </>
  );
};
export default ViewMySumbissionsHistory;
