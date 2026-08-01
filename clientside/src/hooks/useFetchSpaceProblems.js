import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../services/ProblemService";

export default function useFetchSpaceProblems() {
  const { id } = useParams();
  const [problemId, setProblemId] = useState(0);
  const [problemData, setProblemData] = useState("");
  const [iterations, setIterations] = useState(0);
  const [problemSpaceA, setProblemSpaceA] = useState(0);
  const [problemSpaceB, setProblemSpaceB] = useState(0);

  //Fetching the problem
  useEffect(() => {
    getProblem(id)
      .then((response) => {
        setProblemId(response.data.id);
        const problemDataConverted = JSON.parse(response.data.problemData);
        setProblemData(problemDataConverted);
        setIterations(problemDataConverted.iterations);
        setProblemSpaceA(problemDataConverted.problemSpaceA);
        setProblemSpaceB(problemDataConverted.problemSpaceB);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [id]);

  return { problemId, problemData, iterations, problemSpaceA, problemSpaceB };
}
