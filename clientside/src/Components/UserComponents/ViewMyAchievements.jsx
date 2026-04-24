import { useEffect, useState } from "react";
import { getUserAchievements } from "../../services/UserAchievementService";
import { getUserProblems } from "../../services/UserProblemService";
const ViewMyAchievements = () => {
  const [myAchievements, setMyAchievements] = useState([]);
  const [myProblems, setMyProblems] = useState([]);

  const countProblems = myProblems.filter(
    (myProblem) => myProblem.problemId,
  ).length;

  const count = myAchievements.filter(
    (myAchievement) => myAchievement.achievementId,
  ).length;

  const getAllUserAchievements = () => {
    getUserAchievements()
      .then((response) => {
        setMyAchievements(response.data);
        console.log("Api response:", response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const getAllUserProblems = () => {
    getUserProblems()
      .then((response) => {
        setMyProblems(response.data);
        console.log("Api response:", response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    getAllUserAchievements();
  }, []);
  useEffect(() => {
    getAllUserProblems();
  }, []);

  console.log(count);

  const listOfMyAchievements = myAchievements.map((myAchievement) => (
    <div key={myAchievement.achievementId}>
      <div>{myAchievement.category}</div>
      <div>{myAchievement.name}</div>
      <div>{myAchievement.rank}</div>
    </div>
  ));
  return (
    <>
      {count >= 0 ? (
        <>
          <h1>My Achievements</h1>
          <ol>{listOfMyAchievements}</ol>
        </>
      ) : (
        <h1>No achievements Yet!</h1>
      )}
    </>
  );
};
export default ViewMyAchievements;
