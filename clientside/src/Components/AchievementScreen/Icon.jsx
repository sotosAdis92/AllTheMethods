const Icon = (props) => {
  if (props.rank === "Bronze") {
    return <div className="achIconBronze">{props.children}</div>;
  } else if (props.rank === "Silver") {
    return <div className="achIconSilver">{props.children}</div>;
  } else if (props.rank === "Gold") {
    return <div className="achIconGold">{props.children}</div>;
  }
};
export default Icon;
