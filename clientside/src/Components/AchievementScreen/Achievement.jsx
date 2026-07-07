const Achievement = (props) => {
  if (props.rank === "Bronze") {
    return <div className="bronze">{props.children}</div>;
  } else if (props.rank === "Silver") {
    return <div className="silver">{props.children}</div>;
  } else if (props.rank === "Gold") {
    return <div className="gold">{props.children}</div>;
  }
};
export default Achievement;
