import { useEffect, useState } from "react";
import { getProblemsByProblemType } from "../../services/ProblemService";
const ProblemTypePage = (props) => {
  const [problems, setProblems] = useState([]);
  useEffect(() => {
    getProblemsByProblemType(props);
  }, []);
  const listOfProblems = problems.map((problem) => (
    <div>
      <div></div>
    </div>
  ));

  return (
    <div>
      <div>{listOfProblems}</div>
    </div>
  );
};
export default ProblemTypePage;
