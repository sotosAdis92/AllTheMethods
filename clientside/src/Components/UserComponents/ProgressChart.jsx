import { ArcElement, Chart as ChartJS, Legend, Title, Tooltip } from "chart.js";
import { useEffect, useState } from "react";
import { Doughnut } from "react-chartjs-2";
import {
  getCountDistinctProblems,
  getCountProblems,
} from "../../services/UserProblemService";
import ProblemDifficulty from "../ProblemDifficulty";
import "./ProgressChart.css";
ChartJS.register(Tooltip, Legend, ArcElement, Title);

const ProgressChart = (props) => {
  const [count, setCount] = useState([]);
  const [countDistinct, setCountDistinct] = useState([]);
  const userId = props.userId;
  console.log(userId);
  const getCountDistinct = () => {
    getCountDistinctProblems(userId)
      .then((response) => {
        setCountDistinct(response.data);
        console.log("get distinct ", response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  const getCount = () => {
    getCountProblems(userId)
      .then((response) => {
        setCount(response.data);
        console.log("Api response in chart:", response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  useEffect(() => {
    if (userId) {
      getCountDistinct();
      getCount();
    }
  }, [userId]);

  const distinctLabels = countDistinct.map((item) => item[0]);
  const distinctGeneralData = countDistinct.map((item) => item[1]);
  const distinctUserData = countDistinct.map((item) => item[2]);
  const listOfUserData = countDistinct.map((item, i) => {
    return (
      <div key={i} className="containerOfListOfUser">
        <ProblemDifficulty
          difficulty={item[0]}
          className="problemDiff"
        ></ProblemDifficulty>
        <div className="numbers">
          {item[2]}/{item[1]}
        </div>
      </div>
    );
  });
  console.log(distinctGeneralData);
  const centerStatisticsPlugin = {
    id: "centerStatisticsPlugin",
  };

  ChartJS.register(centerStatisticsPlugin);
  return (
    <div className="doughnutContainerDiv">
      <div className="doughnut" style={{}}>
        <Doughnut
          data={{
            labels: distinctLabels,
            datasets: [
              {
                label: "Problems Solved",
                data: distinctUserData,
                backgroundColor: ["#28a697", "#ffbf40", "#ff2d55"],
              },
            ],
          }}
          options={{
            responsive: true,
            maintainAspectRatio: true,
            aspectRatio: 1,
            cutout: "85%",
            plugins: {
              title: {
                display: true,
                text: `${props.displayName} progress`,
                align: "center",
                position: "top",
                font: {
                  size: 22,
                  weight: "bolder",
                },
              },
              legend: {
                display: false,
                labels: {
                  font: {
                    family: "'system-ui','-apple-system'",
                    size: 20,
                    style: "initial",
                    weight: "bolder",
                  },
                  boxWidth: 20,
                  boxHeight: 20,
                  useBorderRadius: true,
                  borderRadius: 4,
                },
              },
            },
          }}
        ></Doughnut>
      </div>
      <div className="listOfUserData">{listOfUserData}</div>
    </div>
  );
};
export default ProgressChart;
