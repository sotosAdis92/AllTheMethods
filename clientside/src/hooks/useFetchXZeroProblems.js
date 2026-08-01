import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../services/ProblemService";
export default function useFetchXZeroProblems() {
  const { id } = useParams();
  const [problemId, setProblemId] = useState(0);
  const [problemData, setProblemData] = useState([]);
  const [problemXoParameter, setProblemXoParameter] = useState(0);
  const [iterations, setIterations] = useState(0);
  const [functionString, setFunctionString] = useState("");

  useEffect(() => {
    getProblem(id).then((response) => {
      setProblemId(response.data.id);
      const parsedData = JSON.parse(response.data.problemData);
      setProblemData(parsedData);
      setIterations(parsedData.iterations);
      setProblemXoParameter(parsedData.xoParameter);
      setFunctionString(response.data.functionString);
      console.log(parsedData);
      console.log(parsedData.xoParameter);
    });
  }, [id]);

  return {
    problemId,
    problemData,
    problemXoParameter,
    iterations,
    functionString,
  };
}
