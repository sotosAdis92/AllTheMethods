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
  });

  const listOfMyAchievements = myAchievements.map((myAchievement) => (
    <div key={myAchievement.achievementId}>
      <div>{myAchievement.category}</div>
      <div>{myAchievement.name}</div>
      <div>{myAchievement.rank}</div>
    </div>
  ));
  const listOfMyProblems = myProblems.map((myProblem) => (
    <div key={myProblem.problemId}>
      <div>{myProblem.title}</div>
      <div>{myProblem.category}</div>
      <div>{myProblem.difficulty}</div>
      <div>{myProblem.points}</div>
    </div>
  ));
  return (
    <>
      <div>
        {count >= 0 ? (
          <>
            <h1>My Achievements</h1>
            <ol>{listOfMyAchievements}</ol>
          </>
        ) : (
          <h1>No achievements Yet!</h1>
        )}
      </div>
      <div>
        {countProblems >= 0 ? (
          <>
            <h1>My Solved Problems</h1>
            <ol>{listOfMyProblems}</ol>
          </>
        ) : (
          <h1>No Problems Solved Yet!</h1>
        )}
      </div>
    </>
  );
};
export default ViewMyAchievements;
