import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../../services/ProblemService";
const BisectionComponent = () => {
  const { id } = useParams();
  const [description, setDescription] = useState("");
  const [problemData, setProblemData] = useState("");
  const [problemString, setProblemString] = useState("");
  const [problemMethod, setProblemMethod] = useState("");

  useEffect(() => {
    getProblem(id)
      .then((response) => {
        setDescription(response.data.description);
        const problemDataConverted = JSON.parse(response.data.problemData);
        setProblemData(problemDataConverted);
        setProblemString(response.data.problemString);
        setProblemMethod(response.data.problemType);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [id]);
  //Implement input generation based on how many iterations you have
  return (
    <>
      <div>
        {description} {problemString} with the {problemMethod} Method
      </div>
      <div>For: {problemData.iterations} iterations</div>
      <div>
        In the Space [{problemData.problemSpaceA},{problemData.problemSpaceB}]
      </div>
      {}
    </>
  );
};

export default BisectionComponent;
