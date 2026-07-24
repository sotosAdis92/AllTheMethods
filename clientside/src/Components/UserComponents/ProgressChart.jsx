import { ArcElement, Chart as ChartJS, Legend, Title, Tooltip } from "chart.js";
import { useEffect, useState } from "react";
import { Doughnut } from "react-chartjs-2";
import { getCountProblems } from "../../services/UserProblemService";
import "./ProgressChart.css";
ChartJS.register(Tooltip, Legend, ArcElement, Title);

const ProgressChart = (props) => {
  const [count, setCount] = useState([]);
  const userId = props.userId;
  console.log(userId);
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
      getCount();
    }
  }, [userId]);

  const labels = count.map((item) => item[0]);
  const dataValues = count.map((item) => item[1]);
  const centerStatisticsPlugin = {
    id: "centerStatisticsPlugin",
  };

  ChartJS.register(centerStatisticsPlugin);
  return (
    <div className="doughnutContainerDiv">
      <div>
        <div>
          <div></div>
          <div></div>
        </div>
        <div>
          <div></div>
          <div></div>
        </div>
        <div>
          <div></div>
          <div></div>
        </div>
      </div>
      <div className="doughnut" style={{}}>
        <Doughnut
          data={{
            labels: labels,
            datasets: [
              {
                label: "Problems Solved",
                data: dataValues,
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
                text: `${props.displayName} Progress`,
                align: "center",
                position: "top",
                font: {
                  size: 22,
                  weight: "bolder",
                },
              },
              legend: {
                display: true,
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
    </div>
  );
};
export default ProgressChart;
