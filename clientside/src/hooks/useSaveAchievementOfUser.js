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
      console.log("=== PROBLEM INFO ===");
      console.log("Full problemInfo:", JSON.stringify(problemInfo, null, 2));

      console.log("\n=== USER ACHIEVEMENT DTO ===");
      console.log(
        "  - achievementId:",
        problemInfo.userAchievementDto.achievementId,
      );
      console.log("  - userId:", problemInfo.userAchievementDto.userId);
      console.log("  - category:", problemInfo.userAchievementDto.category);
      console.log("  - achievedAt:", problemInfo.userAchievementDto.achievedAt);

      console.log("\n=== USER PROBLEM DTO ===");
      console.log("  - userId:", problemInfo.userProblemDto.userId);
      console.log("  - problemId:", problemInfo.userProblemDto.problemId);
      console.log("  - category:", problemInfo.userProblemDto.category);

      console.log("\n=== ACHIEVEMENT DTO ===");
      console.log(
        "  - achievementId:",
        problemInfo.achievementDto.achievementId,
      );
      console.log("  - name:", problemInfo.achievementDto.name);
      console.log("  - description:", problemInfo.achievementDto.description);
      console.log("  - category:", problemInfo.achievementDto.category);
      console.log("  - rank:", problemInfo.achievementDto.rank);
      console.log("  - visibility:", problemInfo.achievementDto.visibility);
      console.log("  - counter:", problemInfo.achievementDto.counter);
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
