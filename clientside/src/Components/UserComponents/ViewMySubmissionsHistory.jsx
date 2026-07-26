import { useEffect, useState } from "react";
import { getAllUserSubmissions } from "../../services/SubmitService";

const ViewMySumbissionsHistory = (props) => {
  const [mySubmissions, setMySubmissions] = useState([]);
  const userId = props.userId;
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
    <div key={i} className="submissionItem">
      <div>{submission.submissionId}</div>
      <div>{submission.problemId}</div>
      <div>{submission.submittedAt}</div>
    </div>
  ));

  return (
    <>
      <div>{listOfMySubmissions}</div>
    </>
  );
};
export default ViewMySumbissionsHistory;
