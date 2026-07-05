import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../services/ProblemService";
export default function useFetchIntegrals() {
  const { id } = useParams();
  const [problemId, setProblemId] = useState(0);
  const [problemData, setProblemData] = useState("");
  const [hParameter, setHparameter] = useState("");
  const [integrationPointA, setIntegrationPointA] = useState("");
  const [integrationPointB, setIntegrationPointB] = useState("");
  const [functionString, setFunctionString] = useState("");

  useEffect(() => {
    getProblem(id).then((response) => {
      setProblemId(response.data.problemId);
      setFunctionString(response.data.functionString);
      const problemDataParsed = JSON.parse(response.data.problemData);
      setProblemData(problemDataParsed);
      setHparameter(problemDataParsed.hParameter);
      setIntegrationPointA(problemDataParsed.integrationSpaceA);
      setIntegrationPointB(problemDataParsed.integrationSpaceB);
    });
  }, [id]);

  return {
    problemId,
    problemData,
    hParameter,
    integrationPointA,
    integrationPointB,
    functionString,
  };
}
