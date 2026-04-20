import { useEffect } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../../services/ProblemService";
const ProblemDescription = () => {
  const { id } = useParams;
  const [description, setDescription] = useState("");
  const [problemString, setProblemString] = useState("");
  const [category, setCategory] = useState("");
  const [problemType, setProblemType] = useState("");
  useEffect(() => {
    getProblem(id)
      .then((response) => {
        setDescription(response.data.description);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [id]);
};
export default ProblemDescription;
