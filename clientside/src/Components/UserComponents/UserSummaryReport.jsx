import { useEffect, useState } from "react";
import { getUserProblemSummaryReport } from "../../services/UserProblemService";
const UserSummaryReport = (props) => {
  const [countProblems, setCountProblems] = useState([]);
  const [acceptanceRate, setAcceptanceRate] = useState([]);
  const userId = props.userId;

  const getSummary = () => {
    getUserProblemSummaryReport(userId).then((response) => {
      setCountProblems(response.data);
      setAcceptanceRate(response.data);
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
  return (
    <>
      <div>
        <div>
          <div>Solved:</div>
          <div>{countUserProblems}</div>
        </div>
        <div>
          <div>Acceptance Rate:</div>
          <div>{countUserAcceptanceRate}%</div>
        </div>
      </div>
    </>
  );
};
export default UserSummaryReport;
