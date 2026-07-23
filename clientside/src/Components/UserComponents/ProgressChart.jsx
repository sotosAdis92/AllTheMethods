import { ArcElement, Chart as ChartJS, Legend, Tooltip } from "chart.js";
import { useEffect, useState } from "react";
import { Doughnut } from "react-chartjs-2";
import { getCountProblems } from "../../services/UserProblemService";
ChartJS.register(Tooltip, Legend, ArcElement);

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
  return (
    <div>
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
        options={{ cutout: 420 }}
      ></Doughnut>
    </div>
  );
};
export default ProgressChart;
