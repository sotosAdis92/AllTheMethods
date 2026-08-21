import { useEffect, useState } from "react";
import { getUserProblemSummaryReport } from "../../services/UserProblemService";
const UserSummaryReport = (props) => {
  const [countProblems, setCountProblems] = useState([]);
  const [acceptanceRate, setAcceptanceRate] = useState([]);
  const userId = props.userId;

  useEffect(() => {
    getUserProblemSummaryReport(userId).then((response) => {
      setCountProblems(response.data.countTotalProblems);
      setAcceptanceRate(response.data.userAcceptanceRate);
    });
  });

  return (
    <>
      <div>
        <div>{countProblems}</div>
        <div>{acceptanceRate}</div>
      </div>
    </>
  );
};
export default UserSummaryReport;
