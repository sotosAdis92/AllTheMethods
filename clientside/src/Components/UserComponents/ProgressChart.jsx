import { ArcElement, Chart as ChartJS, Legend, Tooltip } from "chart.js";
import { Doughnut } from "react-chartjs-2";
ChartJS.register(Tooltip, Legend, ArcElement);
const ProgressChart = (props) => {
  return (
    <div>
      <Doughnut
        data={{
          labels: ["Easy", "Medium", "Hard"],
          datasets: [
            {
              label: "Problems Solved",
              data: [2, 1, 1],
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
