import "katex/dist/katex.min.css";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../../services/ProblemService";
const ProblemDescription = () => {
  const [description, setDescription] = useState("");
  const { id } = useParams();
  useEffect(() => {
    getProblem(id)
      .then((response) => {
        setDescription(response.data.description);
        console.log(description);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [id]);
  const submission = {
    id,
  };
  function handleSubmit() {
    console.log(submission);
  }

  return (
    <>
      <button onClick={handleSubmit}>Submit</button>
      <p>{description}</p>
    </>
  );
};
export default ProblemDescription;
