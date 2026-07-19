import axiosInstance from "../environment/axiosinstance";
const REST_API_BASE_URL = "/api/user/achievements";

export const saveUserAchievement = async (problemInfo) => {
  const response = await axiosInstance.post(
    REST_API_BASE_URL + "/save",
    problemInfo,
  );
  return response;
};
export const getUserAchievements = async (userId) => {
  const response = await axiosInstance.get(
    REST_API_BASE_URL + `/myachievements/${userId}`,
  );
  return response;
};
