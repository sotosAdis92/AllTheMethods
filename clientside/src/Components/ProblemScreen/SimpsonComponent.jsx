import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getAchievementsByCategory } from "../../services/AchievementService";
import { decideResultText } from "../../services/GeneralFunctions";
import { getProblem } from "../../services/ProblemService";
import { saveSubmission, sendSimposonData } from "../../services/SubmitService";
import { saveUserAchievement } from "../../services/UserAchievementService";
import { saveSolvedProblem } from "../../services/UserProblemService";
import { getUser } from "../../services/UsersService";
import FormInput from "../FormInput";

const SimpsonComponent = (props) => {
  const { id } = useParams();
  const [hParameter, setHparameter] = useState("");
  const [integrationPointA, setIntegrationPointA] = useState("");
  const [integrationPointB, setIntegrationPointB] = useState("");
  const [problemData, setProblemData] = useState("");
  const [achievements, setAchievements] = useState([]);
  const [userId, setUsersId] = useState(0);
  const [generalError, setGeneralError] = useState("");
  const [problemId, setProblemId] = useState(0);
  const [input, setInput] = useState([]);
  const [inp, setInputI] = useState([]);
  const [result, setResult] = useState(false);
  const [isButtonDisabled, setButtonDisabled] = useState(false);
  const [resultText, setResultText] = useState("");
  let text;
  const [values, setValues] = useState({
    entry: "",
  });
  var entries = [];

  console.log(id);
  useEffect(() => {
    getProblem(id).then((response) => {
      const problemDataParsed = JSON.parse(response.data.problemData);
      setProblemData(problemDataParsed);
      setHparameter(problemDataParsed.hParameter);
      setIntegrationPointA(problemDataParsed.integrationSpaceA);
      setIntegrationPointB(problemDataParsed.integrationSpaceB);
      console.log(hParameter);
      console.log(problemData);
    });
  }, [id]);

  useEffect(() => {
    getAchievementsByCategory(props.problemCategory)
      .then((response) => {
        console.log(response.data);
        const fetchedData = [];
        for (let i = 0; i < response.data.length; i++) {
          const achievement = response.data[i];
          fetchedData.push(achievement);
        }
        setAchievements(fetchedData);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [props.problemCategory]);
  console.log(achievements);

  useEffect(() => {
    getUser().then((response) => {
      setUsersId(response.data.id);
    });
  });

  useEffect(() => {
    if (props.isSolved) {
      disableButton();
    }
  });

  const disableButton = () => {
    setButtonDisabled(true);
  };

  function validateForm() {
    let valid = true;
    if (inp.length != integrationPointB - integrationPointA || text === 0) {
      valid = false;
      setGeneralError("One or more inputs are empty");
    } else {
      setGeneralError("");
    }
    return valid;
  }

  //function that takes in an index and the inputted value and either when the user enters a new value puts it into the array or replaces it
  //later it sorts it for the index value so that x0 = index 0 ... x1 = index 1 ... xn = index n
  //creates a copy and saves it
  function handleInput(i, e) {
    const value = Number(e.target.value);
    const indexOfNumber = input.findIndex(
      (inputtedNumber) => inputtedNumber[0] === i,
    );
    if (indexOfNumber !== -1) {
      input[indexOfNumber] = [i, value];
    } else {
      input.push([i, Number(e.target.value)]);
    }
    input.sort();
    const inp = input.map((num) => num[1]);
    setInput([...input]);
    setInputI(inp);

    console.log(input);
    console.log(inp);

    if (inp.length >= 1) {
      setGeneralError("");
    }
  }

  //Setting up the local time objects for the submission
  const d = new Date();
  let date = d.toLocaleDateString();
  let time = d.toLocaleTimeString();
  let submittedAt = date + " " + time;

  //Implement input generation based on how many iterations you have
  for (let i = integrationPointA; i <= integrationPointB + 1; i++) {
    if (i === integrationPointA || i === integrationPointB) {
      entries.push({
        id: i,
        placeholder: `f(${i})`,
        type: "number",
        label: `f(${i}) = `,
        name: "",
        i: { i },
        required: true,
      });
    } else if (i === integrationPointB + 1) {
      entries.push({
        id: i,
        placeholder: `Final Sum`,
        label: `S = `,
        name: "",
        i: { i },
        required: true,
      });
    } else if ((i - integrationPointA) % 2 === 1) {
      entries.push({
        id: i,
        placeholder: `4f(${i})`,
        type: "number",
        label: `4f(${i}) = `,
        name: "",
        i: { i },
        required: true,
      });
    } else {
      entries.push({
        id: i,
        placeholder: `2f(${i})`,
        type: "number",
        label: `2f(${i}) = `,
        name: "",
        i: { i },
        required: true,
      });
    }
  }

  //Props passed in from parrent element
  let problemMethod = props.problemMethod;
  let problemString = props.problemString;
  let problemCategory = props.problemCategory;
  const differenceOfIntegration = integrationPointB - integrationPointA;
  //Submitting data based on what method we have rendered to reduce if checks for both client and server
  const submissionData = {
    inp,
    problemMethod,
    problemString,
    differenceOfIntegration,
    integrationPointA,
    integrationPointB,
  };

  const submission = {
    problemId,
    userId,
    submittedAt,
  };

  const savedProblem = {
    userId,
    problemId,
    problemCategory,
  };

  const submitSimpsonData = async () => {
    if (validateForm()) {
      saveSubmission(submission).then((response) => {
        console.log(response.data);
      });
      const response = sendSimposonData(submissionData);
      const resultOfServer = response.data;
      setResult(resultOfServer);

      await decideResultText(result);
      await decideToSaveSolvedProblem(result);
      await saveAchievementOfUser(result);
    }
  };

  //Function to save or not to save the problem based on the result that is returned by the server
  const decideToSaveSolvedProblem = (result) => {
    if (result === true) {
      saveSolvedProblem(savedProblem).then((response) => {
        console.log(response.data);
      });
      disableButton();
    } else {
      return;
    }
  };

  const saveAchievementOfUser = (result) => {
    if (result === true) {
      for (let i = 0; i < achievements.length; i++) {
        setUsersId(
          getUser()
            .then((response) => {
              setUsersId(response.data.id);
            })
            .catch((error) => {
              console.log(error);
            }),
        );
        setProblemId(
          getProblem(id)
            .then((response) => {
              setProblemId(response.data.problemId);
            })
            .catch((error) => {
              console.log(error);
            }),
        );
        const problemInfo = {
          userAchievementDto: {
            achievementId: achievements[i].achievementId,
            userId: userId,
            category: achievements[i].category,
          },
          userProblemDto: {
            userId: userId,
            problemId: problemId,
            category: achievements[i].category,
          },
          achievementDto: {
            achievementId: achievements[i].achievementId,
            name: achievements[i].name,
            description: achievements[i].description,
            category: achievements[i].category,
            rank: achievements[i].rank,
            visibility: achievements[i].visibility,
            counter: achievements[i].counter,
          },
        };

        console.log(achievements[i].achievementId + ": Achievement Id");
        console.log(achievements[i].description);
        console.log(achievements[i].rank);
        console.log(achievements[i].visibility);
        console.log(achievements[i].category);
        console.log(achievements[i].counter);
        console.log(achievements[i].name);
        console.log(userId);
        console.log(problemId);
        saveUserAchievement(problemInfo)
          .then((response) => {
            console.log(response.data.counter);
          })
          .catch((error) => {
            console.log(error);
          });
      }
    } else {
      return;
    }
  };

  return (
    <>
      <button
        type="button"
        disabled={isButtonDisabled}
        onClick={() => submitSimpsonData()}
      >
        Submit
      </button>
      <div></div>
      <form name="inputForm" id="form">
        {entries.map((entry) => (
          <FormInput
            key={entry.id}
            {...entry}
            value={values[entry.name]}
            onChange={(e) => handleInput(entry.id, e)}
          ></FormInput>
        ))}
      </form>
      <span className="generalError">{generalError}</span>
      <div>{props.isSolved ? <div></div> : <div>{resultText}</div>}</div>
    </>
  );
};
export default SimpsonComponent;
