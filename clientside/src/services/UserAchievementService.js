import axiosInstance from "../enviroment/axiosinstance";
const REST_API_BASE_URL = "/api/userAchievements";

export const saveUserAchievement = async (problemInfo) => {
  const response = await axiosInstance.post(
    REST_API_BASE_URL + "/saveAchievements",
    problemInfo,
  );
  return response;
};
export const getUserAchievements = async () => {
  const response = await axiosInstance.get(
    REST_API_BASE_URL + "/myAchievements",
  );
  return response;
};
