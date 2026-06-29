import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../services/ProblemService";
export default function useFetchDifferentialEquations() {
  const { id } = useParams();
  const [problemData, setProblemData] = useState("");
  const [xZero, setProblemXoParameter] = useState(0);
  const [yZero, setProblemYoParameter] = useState(0);
  const [iterations, setIterations] = useState(0);
  const [hParameter, setProblemHparameter] = useState(0);
  const [problemId, setProblemId] = useState(0);
  const [functionString, setFunctionString] = useState("");
  console.log(problemData);
  //Fetching the problem
  useEffect(() => {
    getProblem(id)
      .then((response) => {
        setProblemId(response.data.problemId);
        setFunctionString(response.data.functionString);
        const problemDataConverted = JSON.parse(response.data.problemData);
        setProblemData(problemDataConverted);
        setIterations(problemDataConverted.iterations);
        setProblemXoParameter(problemDataConverted.xZero);
        setProblemYoParameter(problemDataConverted.yZero);
        setProblemHparameter(problemDataConverted.hParameter);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [id]);

  return { problemId, iterations, xZero, yZero, hParameter, functionString };
}
