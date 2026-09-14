import { useEffect, useState } from "react";

const ProblemTypePage = (props) => {
  const [problems, setProblems] = useState([]);
  useEffect(() => {}, []);
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
