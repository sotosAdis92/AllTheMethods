import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../../services/ProblemService";
const ProblemDescription = () => {
  const { id } = useParams;
  const [description, setDescription] = useState("");
  const [problemString, setProblemString] = useState("");
  const [category, setCategory] = useState("");
  const [problemType, setProblemType] = useState("");
  const [difficulty, setDifficulty] = useState("");
  useEffect(() => {
    getProblem(id)
      .then((response) => {
        setDescription(response.data.description);
        setProblemString(response.data.problemString);
        setProblemType(response.data.problemType);
        setCategory(response.data.category);
        setDifficulty(response.data.difficulty);
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
    </>
  );
};
export default ProblemDescription;
