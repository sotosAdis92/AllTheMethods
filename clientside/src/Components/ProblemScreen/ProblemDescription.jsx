import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../../services/ProblemService";
const ProblemDescription = () => {
  const { id } = useParams();
  const [description, setDescription] = useState("");
  const [problemString, setProblemString] = useState("");
  const [category, setCategory] = useState("");
  const [problemType, setProblemType] = useState("");
  const [difficulty, setDifficulty] = useState("");
  const [problemData, setProblemData] = useState("");
  useEffect(() => {
    getProblem(id)
      .then((response) => {
        setDescription(response.data.description);
        setProblemString(response.data.problemString);
        setProblemType(response.data.problemType);
        setCategory(response.data.category);
        setDifficulty(response.data.difficulty);
        const parsedData = JSON.parse(response.data.problemData);
        setProblemData(parsedData);
        console.log(parsedData.iterations);
        console.log(parsedData.problemSpaceA);
        console.log(parsedData.problemSpaceB);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [id]);

  return (
    <>
      <div>{description}</div>
      <div>{problemString}</div>
      <div>{category}</div>
      <div>{problemType}</div>
      <div>{difficulty}</div>
      <div>{problemData.problemSpaceA}</div>
    </>
  );
};
export default ProblemDescription;
