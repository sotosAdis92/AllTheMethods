import useState, { useEffect } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../../services/ProblemService";
const RegulaFalsiComponent = (props) => {
  const { id } = useParams();
  const [problemName, setProblemName] = useState("");
  const [problemSpaceA, setProblemSpaceA] = useState(0);
  const [problemSpaceB, setProblemSpaceB] = useState(0);
  const [iterations, setIterations] = useState(0);
  const [problemDescription, setProblemDescription] = useState("");
  const [problemString, setProblemString] = useState("");
  const [problemMethod, setProblemMethod] = useState("");
  const [problemCategory, setProblemCategory] = useState("");
  const [problemData, setProblemData] = useState("");
  console.log(props.isSolved);
  useEffect(() => {
    getProblem(id)
      .then((response) => {
        console.log(response.data);
        setProblemName(response.data.name);
        setProblemMethod(response.data.problemType);
        setProblemCategory(response.data.category);
        console.log(problemName);
      })
      .catch((error) => {
        console.log(error.data);
      });
  });
};
export default RegulaFalsiComponent;
