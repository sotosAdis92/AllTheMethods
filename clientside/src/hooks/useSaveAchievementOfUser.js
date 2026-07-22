import { getProblem } from "../services/ProblemService";
import { saveUserAchievement } from "../services/UserAchievementService";
import { getUser } from "../services/UsersService";
export default function useSaveAchievementOfUser() {
  const saveAchievementOfUser = async (id, result, achievements) => {
    for (let i = 0; i < achievements.length; i++) {
      const userResponse = await getUser();
      const problemResponse = await getProblem(id);
      const userId = userResponse.data.id;
      const problemId = problemResponse.data.problemId;

      const achievedAt = new Date().toISOString();

      const problemInfo = {
        userAchievementDto: {
          achievementId: achievements[i].achievementId,
          userId: userId,
          category: achievements[i].category,
          achievedAt: achievedAt,
        },
        userProblemDto: {
          userId: userId,
          problemId: problemId,
          category: achievements[i].category,
        },
        achievementDto: {
          achievementId: achievements[i].achievementId,
          name: achievements[i].name,
          description: achievements[i].description,
          category: achievements[i].category,
          rank: achievements[i].rank,
          visibility: achievements[i].visibility,
          counter: achievements[i].counter,
        },
      };
      saveUserAchievement(problemInfo)
        .then((response) => {
          console.log(response.data.counter);
        })
        .catch((error) => {
          console.log(error);
        });
    }
  };
  return { saveAchievementOfUser };
}
