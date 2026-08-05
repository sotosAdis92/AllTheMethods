import "./AboutPage/About.css";
const Tooltip = (props) => {
  return (
    <div className="wrapper">
      <div className="icon">
        <div className={props.styling}>{props.content}</div>
      </div>
    </div>
  );
};

export default Tooltip;
