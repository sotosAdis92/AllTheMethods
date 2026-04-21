import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../../services/ProblemService";
const ProblemDescription = () => {
  const { id } = useParams();
  const [problemType, setProblemType] = useState("");
  // const [problemData, setProblemData] = useState("");
  useEffect(() => {
    getProblem(id)
      .then((response) => {
        setProblemType(response.data.problemType);
        // const parsedData = JSON.parse(response.data.problemData);
        // setProblemData(parsedData);
        // console.log(parsedData.iterations);
        // console.log(parsedData.problemSpaceA);
        // console.log(parsedData.problemSpaceB);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [id]);

  return (
    <>
      <div>{problemType}</div>
    </>
  );
};
export default ProblemDescription;
