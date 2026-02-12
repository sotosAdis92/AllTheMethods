import "../App.css";

const DifficultyComponent = (props) => {
  if (props.difficulty == "Easy") {
    return <div className="easy">{props.difficulty}</div>;
  } else if (props.difficulty == "Medium") {
    return <div className="medium">{props.difficulty}</div>;
  } else if (props.difficulty == "Hard") {
    return <div className="hard">{props.difficulty}</div>;
  }
};
export default DifficultyComponent;
