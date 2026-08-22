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
      setCountProblems(response.data);
      setAcceptanceRate(response.data);
      setSubmissionsOfUser(response.data);
    });
  };
  useEffect(() => {
    if (userId) {
      getSummary();
    }
  }, [userId]);

  const countUserProblems = countProblems.map(
    (item) => item.countTotalProblems,
  );
  const countUserAcceptanceRate = acceptanceRate.map(
    (item) => item.userAcceptanceRate,
  );
  const countSubmissions = submissionsOfUser.map(
    (item) => item.countSubmissions,
  );
  return (
    <>
      <div className="summaryReportContainer">
        <h1 className="summaryReportHeading">
          <div className="headerText">Summary</div>
        </h1>
        <div className="userSolvedCounter">
          Solved
          <div className="solvedCounterSu">{countUserProblems}</div>
        </div>
        <div>
          Submissions
          <div>{countSubmissions}</div>
        </div>
        <div className="acceptanceRate">
          Acceptance Rate
          <div className="acceptancePercent">{countUserAcceptanceRate}%</div>
        </div>
      </div>
    </>
  );
};
export default UserSummaryReport;
