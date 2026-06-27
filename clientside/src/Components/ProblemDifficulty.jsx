const ProblemDifficulty = (props) => {
  if (props.difficulty === "Easy") {
    return <div className="easyDifficulty">{props.difficulty}</div>;
  } else if (props.difficulty === "Med.") {
    return <div className="mediumDifficulty">{props.difficulty}</div>;
  } else if (props.difficulty === "Hard") {
    return <div className="hardDifficulty">{props.difficulty}</div>;
  }
};
export default ProblemDifficulty;
