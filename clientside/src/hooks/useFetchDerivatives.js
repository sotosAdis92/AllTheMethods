import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../services/ProblemService";
export default function useFetchDerivatives() {
  const { id } = useParams();
  const [problemId, setProblemId] = useState(0);
  const [problemData, setProblemData] = useState("");
  const [iterations, setIterations] = useState("");
  const [xZero, setProblemXZeroParameter] = useState(0);
  const [countingParameters, setCoutingParameters] = useState([]);
  const [xiParameters, setXiParameters] = useState([]);
  const [fiParameters, setFiParameters] = useState([]);
  const [typeOfDerivative, setTypeOfDerivative] = useState("");

  useEffect(() => {
    getProblem(id).then((response) => {
      const parsedData = JSON.parse(response.data.problemData);
      setProblemId(response.data.problemId);
      setProblemData(parsedData);
      setIterations(parsedData.iterations);
      setProblemXZeroParameter(parsedData.xZero);
      setCoutingParameters(parsedData.countingParameters);
      setXiParameters(parsedData.xiParameters);
      setFiParameters(parsedData.fiParameters);
      setTypeOfDerivative(parsedData.typeOfDerivative);
    });
  }, [id]);
  return {
    problemId,
    problemData,
    iterations,
    xZero,
    countingParameters,
    xiParameters,
    fiParameters,
    typeOfDerivative,
  };
}
