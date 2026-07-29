const AchievementRank = (props) => {
  if (props.rank === "Bronze") {
    return <div className="bronzeRank">{props.rank}</div>;
  } else if (props.rank === "Silver") {
    return <div className="silverRank">{props.rank}</div>;
  } else if (props.rank === "Gold") {
    return <div className="goldRank">{props.rank}</div>;
  }
};
export default AchievementRank;
