import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getAchievementsByCategory } from "../../services/AchievementService";
import { getProblem } from "../../services/ProblemService";
const TrapezodialRuleComponent = (props) => {
  const { id } = useParams;
  const [hParameter, setHparameter] = useState("");
  const [integrationPointA, setIntegrationPointA] = useState("");
  const [integrationPointB, setIntegrationPointB] = useState("");
  const [problemData, setProblemData] = useState("");
  const [achievements, setAchievements] = useState([]);
  useEffect(() => {
    getProblem(id).then((response) => {
      const problemDataParsed = JSON.parse(response.data.problemData);
      setProblemData(problemDataParsed);
      setHparameter(problemDataParsed.hParameter);
      setIntegrationPointA(problemDataParsed.integrationPointA);
      setIntegrationPointB(problemDataParsed.integrationPointB);
      console.log(hParameter);
      console.log(integrationPointA);
      console.log(integrationPointB);
      console.log(problemData);
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
};
export default TrapezodialRuleComponent;
