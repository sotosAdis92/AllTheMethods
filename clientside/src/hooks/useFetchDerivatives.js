import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../services/ProblemService";
export default function useFetchDerivatives() {
  const { id } = useParams();
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
      setProblemData(parsedData);
      setIterations(parsedData.iterations);
      setProblemXZeroParameter(parsedData.problemXoParameter);
      setCoutingParameters(parsedData.countingParameters);
      setXiParameters(parsedData.xiParameters);
      setFiParameters(parsedData.fiParameters);
      setTypeOfDerivative(parsedData.typeOfDerivative);
    });
  }, [id]);
}
