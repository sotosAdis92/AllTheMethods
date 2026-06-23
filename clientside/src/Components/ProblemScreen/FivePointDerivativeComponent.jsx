import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getAchievementsByCategory } from "../../services/AchievementService";
import { decideResultText } from "../../services/GeneralFunctions";
import { getProblem } from "../../services/ProblemService";
import {
  saveSubmission,
  sendRichardsonData,
} from "../../services/SubmitService";
import { saveUserAchievement } from "../../services/UserAchievementService";
import { saveSolvedProblem } from "../../services/UserProblemService";
import { getUser } from "../../services/UsersService";

const FivePointDerivativeComponent = (props) => {
  const { id } = useParams();
  const [problemData, setProblemData] = useState("");
  const [xZero, setProblemXZeroParameter] = useState(0);
  const [iterations, setIterations] = useState("");
  const [userId, setUsersId] = useState("");
  const [input, setInput] = useState([]);
  const [inp, setInputI] = useState([]);
  const [problemId, setProblemId] = useState(0);
  const [generalError, setGeneralError] = useState("");
  const [result, setResult] = useState(false);
  const [resultText, setResultText] = useState("");
  const [achievements, setAchievements] = useState([]);
  const [isButtonDisabled, setButtonDisabled] = useState(false);
  const [countingParameters, setCoutingParameters] = useState([]);
  const [xiParameters, setXiParameters] = useState([]);
  const [fiParameters, setFiParameters] = useState([]);
  const [hParameter, setHparameter] = useState(0);
  let text;
  const [values, setValues] = useState({
    entry: "",
  });
  var entries = [];

  useEffect(() => {
    getProblem(id).then((response) => {
      const parsedData = JSON.parse(response.data.problemData);
      setProblemData(parsedData);
      setIterations(parsedData.iterations);
      setProblemXZeroParameter(parsedData.problemXoParameter);
      setCoutingParameters(parsedData.countingParameters);
      setXiParameters(parsedData.xiParameters);
      setFiParameters(parsedData.fiParameters);
      setHparameter(parsedData.hParameter);
    });
  });

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

  useEffect(() => {
    if (props.isSolved) {
      disableButton();
    }
  });
  //Implement input generation based on how many iterations you have
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

  function validateForm() {
    let valid = true;
    if (inp.length != iterations || text === 0) {
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

  const d = new Date();
  let date = d.toLocaleDateString();
  let time = d.toLocaleTimeString();
  let submittedAt = date + " " + time;

  //Props passed in from parrent element
  let problemMethod = props.problemMethod;
  let problemString = props.problemString;
  let problemCategory = props.problemCategory;

  //Submitting data based on what method we have rendered to reduce if checks for both client and server
  const submissionData = {
    inp,
    problemMethod,
    problemString,
    iterations,
    countingParameters,
    xiParameters,
    fiParameters,
    xZero,
    hParameter,
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

  const submitRichardsonData = async () => {
    if (validateForm()) {
      await saveSubmission(submission).then((response) => {
        console.log(response.data);
      });
      const response = sendRichardsonData(submissionData);
      const resultOfFetch = response.data;
      setResult(resultOfFetch);
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
        onClick={() => submitRichardsonData()}
      >
        Submit
      </button>
      <div>For: {problemData.iterations} iterations</div>
      <div>Starting at[{problemData.problemXoParameter}]</div>
      <form name="inputForm">
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

export default FivePointDerivativeComponent;
