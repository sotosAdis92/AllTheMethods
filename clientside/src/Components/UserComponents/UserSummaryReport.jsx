import { useEffect, useState } from "react";
import { getUserProblemSummaryReport } from "../../services/UserProblemService";
import "./UserSummaryReport.css";
const UserSummaryReport = (props) => {
  const [countProblems, setCountProblems] = useState([]);
  const [acceptanceRate, setAcceptanceRate] = useState([]);
  const [submissionsOfUser, setSubmissionsOfUser] = useState([]);
  const userId = props.userId;

  const getSummary = () => {
    getUserProblemSummaryReport(userId).then((response) => {
      setCountProblems(response.data.countTotalProblems);
      setAcceptanceRate(response.data.userAcceptanceRate);
      setSubmissionsOfUser(response.data.countSubmissions);
    });
  };
  useEffect(() => {
    if (userId) {
      getSummary();
    }
  }, [userId]);

  return (
    <>
      <div className="summaryReportContainer">
        <div className="userSolvedCounter">
          Solved
          <div className="solvedCounterSu">{countProblems}</div>
        </div>
        <div>
          Submissions
          <div className="submissionsCountSu">{submissionsOfUser}</div>
        </div>
        <div className="acceptanceRate">
          Acceptance Rate
          <div className="acceptancePercent">{acceptanceRate}%</div>
        </div>
      </div>
    </>
  );
};
export default UserSummaryReport;
