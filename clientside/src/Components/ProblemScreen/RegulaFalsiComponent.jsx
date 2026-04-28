import useState, { useEffect } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../../services/ProblemService";
const RegulaFalsiComponent = (props) => {
  const { id } = useParams();
  const [problemName, setProblemName] = useState("");
  console.log(props.isSolved);
  useEffect(() => {
    getProblem(id)
      .then((response) => {
        console.log(response.data);
        setProblemName(response.data.name);
        console.log(problemName);
      })
      .catch((error) => {
        console.log(error.data);
      });
  });
};
export default RegulaFalsiComponent;
