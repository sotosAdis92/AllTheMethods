import useState, { useEffect } from "react";
import { useParams } from "react-router-dom";
import { getAchievementsByCategory } from "../../services/AchievementService";
import { getProblem } from "../../services/ProblemService";
import { getUser } from "../../services/UsersService";
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
  const [userId, setUserId] = useState(0);
  const [isButtonDisabled, setButtonDisabled] = useState(false);
  const [problemId, setProblemId] = useState(0);
  var entries = [];
  const [values, setValues] = useState({
    entry: "",
  });
  console.log(props.isSolved);
  useEffect(() => {
    getProblem(id)
      .then((response) => {
        console.log(response.data);
        setProblemId(response.data.id);
        setProblemName(response.data.name);
        setProblemMethod(response.data.problemType);
        setProblemCategory(response.data.category);
        const parsedData = JSON.parse(response.data.problemData);
        setProblemSpaceA(parsedData.problemSpaceA);
        setProblemSpaceB(parsedData.problemSpaceB);
        setIterations(parsedData.iterations);
        console.log(problemName);
        console.log(problemMethod);
        console.log(problemData);
        console.log(problemCategory);
      })
      .catch((error) => {
        console.log(error.data);
      });
  });
  //Fetching data
  useEffect(() => {
    getAchievementsByCategory(problemCategory)
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [problemCategory]);

  useEffect(() => {
    getUser().then((response) => {
      setUserId(response.data.id);
    });
  });

  useEffect(() => {
    if (props.isSolved) {
      disableButton();
    }
  });

  for (let i = 0; i < iterations; i++) {
    entries.push({
      id: i,
      placeholder: `x${i}`,
      type: "number",
      label: `x${i} = `,
      name: "",
      i: { i },
      required: true,
    });
  }

  const disableButton = () => {
    setButtonDisabled(true);
  };

  const d = new Date();
  let date = d.toLocaleDateString();
  let time = d.toLocaleTimeString();
  let submittedAt = date + " " + time;

  const submissionData = {
    inp,
    problemMethod,
    problemString,
    iterations,
    problemSpaceA,
    problemSpaceB,
  };

  const submission = {
    problemId,
    userId,
    submittedAt,
  };
};
export default RegulaFalsiComponent;
