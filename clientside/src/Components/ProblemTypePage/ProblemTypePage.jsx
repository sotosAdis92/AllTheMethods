import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblemsByProblemType } from "../../services/ProblemService";
const ProblemTypePage = () => {
  const [problems, setProblems] = useState([]);
  const { type } = useParams();
  console.log(type);
  useEffect(() => {
    getProblemsByProblemType(type)
      .then((response) => {
        setProblems(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const listOfProblems = problems.map((problem) => (
    <div key={problem.id}>
      <div>{problem.title}</div>
    </div>
  ));

  return (
    <div>
      <div>
        <img></img>
        <h2>{type}</h2>
      </div>
      <div>{listOfProblems}</div>
    </div>
  );
};
export default ProblemTypePage;
