import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../services/ProblemService";

export default function useFetchLinearSystems() {
  const { id } = useParams();
  const [problemId, setProblemId] = useState(0);
  const [problemData, setProblemData] = useState("");
  const [matrix, setMatrix] = useState([]);

  useEffect(() => {
    getProblem(id)
      .then((response) => {
        setProblemId(response.data.id);
        const problemDataConverted = JSON.parse(response.data.problemData);
        setProblemData(problemDataConverted);
        setMatrix(problemDataConverted.matrix);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [id]);

  return { problemId, problemData, matrix };
}
