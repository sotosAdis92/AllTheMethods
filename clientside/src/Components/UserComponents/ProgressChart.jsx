import { ArcElement, Chart as ChartJS, Legend, Title, Tooltip } from "chart.js";
import { useEffect, useState } from "react";
import { Doughnut } from "react-chartjs-2";
import { getProblemsCount } from "../../services/ProblemService";
import {
  getCountDistinctProblems,
  getCountProblems,
  getUserProblems,
} from "../../services/UserProblemService";
import ProblemDifficulty from "../ProblemDifficulty";
import "./ProgressChart.css";
ChartJS.register(Tooltip, Legend, ArcElement, Title);

const ProgressChart = (props) => {
  const [count, setCount] = useState([]);
  const [countDistinct, setCountDistinct] = useState([]);
  const [countAllProblems, setCountAllProblems] = useState(0);
  const [userCount, setUserCount] = useState(0);
  const userId = props.userId;

  const getCountDistinct = () => {
    getCountDistinctProblems(userId)
      .then((response) => {
        setCountDistinct(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const getUserProblemsCount = () => {
    getUserProblems(userId)
      .then((response) => {
        setUserCount(response.data.content);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const getAllProblemsCount = () => {
    getProblemsCount()
      .then((response) => {
        setCountAllProblems(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const getCount = () => {
    getCountProblems(userId)
      .then((response) => {
        setCount(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  useEffect(() => {
    if (userId) {
      getCountDistinct();
      getCount();
      getUserProblemsCount();
      getAllProblemsCount();
    }
  }, [userId]);

  const distinctLabels = countDistinct.map((item) => item.difficulty);
  const distinctGeneralData = countDistinct.map((item) => item.countDifficulty);
  const distinctUserData = countDistinct.map((item) => item.countDistinct);
  const listOfUserData = countDistinct.map((item, i) => {
    return (
      <div key={i} className="containerOfListOfUser">
        <ProblemDifficulty
          difficulty={item.difficulty}
          className="problemDiff"
        ></ProblemDifficulty>
        <div className="numbers">
          {item.countDistinct}/{item.countDifficulty}
        </div>
      </div>
    );
  });

  const stackedText = {
    id: "stackedText",
    afterDatasetsDraw(chart, args, options) {
      const {
        ctx,
        chartArea: { top, bottom, left, right, width, height },
      } = chart;
      const allCount = chart.options.allCount;
      const userCount = chart.options.userCount;
      ctx.save();
      ctx.font = "2.5rem system-ui";
      ctx.fillStyle = "black";
      ctx.textAlign = "center";
      ctx.fillText(userCount, width / 2 - 11, height / 2);

      ctx.save();
      ctx.font = "1.2rem system-ui";
      ctx.fillStyle = "black";
      ctx.textAlign = "center";
      ctx.fillText(`/${allCount}`, width / 2 + 11, height / 2);

      ctx.save();
      ctx.font = "0.9rem system-ui";
      ctx.fillStyle = "black";
      ctx.textAlign = "center";
      ctx.fillText("Solved", width / 2, height / 2 + 25);
    },
  };

  ChartJS.register(stackedText);
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
                backgroundColor: ["#00b8a3", "#ffbf40", "#FF375F"],
              },
            ],
          }}
          options={{
            responsive: true,
            maintainAspectRatio: true,
            aspectRatio: 1,
            cutout: "93%",
            userCount: userCount.length,
            allCount: countAllProblems,
            plugins: {
              title: {
                display: false,
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
          plugins={[stackedText]}
        ></Doughnut>
      </div>
      <div className="listOfUserData">{listOfUserData}</div>
    </div>
  );
};
export default ProgressChart;
