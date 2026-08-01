import { useEffect, useState } from "react";
import "../../App.css";
import img from "../../assets/arrows.png";
import { getAllUserSubmissions } from "../../services/SubmitService";
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
      <div>
        {submission.number}. {submission.title}
      </div>
      <div>{submission.date}</div>
    </div>
  ));

  return (
    <>
      {count > 0 ? (
        <>
          <div className="submissionsContainer">
            <div className="imageAndText">
              <div className="plainText">
                <h1 className="submissionsHeader">
                  <img src={img} className="image"></img>
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
        </>
      ) : (
        <>
          <h1 className="userProblemsHeader">Submission History</h1>
          <div className="userProblemsCounter">Total Submissions: {count}</div>
          <img src={img} className="countZeroImage"></img>
          <p className="noProblems">No Submissions Yet!!</p>
        </>
      )}
    </>
  );
};
export default ViewMySumbissionsHistory;
