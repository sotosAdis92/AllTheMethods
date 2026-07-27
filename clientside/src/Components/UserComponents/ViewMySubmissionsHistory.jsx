import { useEffect, useState } from "react";
import { getAllUserSubmissions } from "../../services/SubmitService";
import ProblemDifficulty from "../ProblemDifficulty";

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
      <div>
        {submission[1]}. {submission[2]}
        <ProblemDifficulty difficulty={submission[3]}></ProblemDifficulty>
        {submission[0]}
      </div>
    </div>
  ));

  return (
    <>
      <div>{listOfMySubmissions}</div>
    </>
  );
};
export default ViewMySumbissionsHistory;
