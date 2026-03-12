import "katex/dist/katex.min.css";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProblem } from "../../services/ProblemService";
import { getUser } from "../../services/UsersService";
const ProblemDescription = () => {
  const [description, setDescription] = useState("");
  const [userId, setUserId] = useState(0);
  const { id } = useParams();
  const [submissionDate, setSubmissionDate] = useState("");

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

  const userIdFunction = () => {
    getUser()
      .then((response) => {
        setUserId(response.data.id);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  useEffect(() => {
    userIdFunction();
  }, []);

  const now = new Date();
  const date = now.getDate();
  const year = now.getFullYear();
  const month = now.getMonth();

  const wholeDate = date + "/" + (month + 1) + "/" + year;

  const submission = {
    id,
    userId,
    wholeDate,
  };

  function detectIterations(description) {
    const string = description.match(/[0-9]\siterations/);
    const iterationsString = String(string);
    const iterations = iterationsString.match(/[0-9]/);
    const numberIterations = parseInt(iterations);
    console.log(numberIterations);
  }

  function detectProblem(description) {
    const string = description.match(/(d+X?|X)\^\d+\s*[-+*/]\s*\d+X?/);
    const problemString = String(string[0]);
    console.log(problemString);
  }

  useEffect(() => {
    detectIterations(description);
    detectProblem(description);
  });
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
