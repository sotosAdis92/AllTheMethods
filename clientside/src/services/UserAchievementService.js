import axiosInstance from "../enviroment/axiosinstance";
const REST_API_BASE_URL = "/api/userAchievements/myAchievements";
export const getUserAchievements = async () => {
  const response = await axiosInstance.get(REST_API_BASE_URL);
  return response;
};
