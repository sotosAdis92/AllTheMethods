import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../../services/ProblemService";
const BisectionComponent = () => {
  const { id } = useParams();
  const [description, setDescription] = useState("");
  const [problemData, setProblemData] = useState("");
  const [problemString, setProblemString] = useState("");

  useEffect(() => {
    getProblem(id)
      .then((response) => {
        setDescription(response.data.description);
        const problemDataConverted = JSON.parse(response.data.problemData);
        setProblemData(problemDataConverted);
        setProblemString(response.data.problemString);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [id]);

  return (
    <>
      <div>{description}</div>
      <div>{problemData.iterations}</div>
      <div>{problemData.problemSpaceA}</div>
      <div>{problemData.problemSpaceB}</div>
      <div>{problemString}</div>
    </>
  );
};

export default BisectionComponent;
