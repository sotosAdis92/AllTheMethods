import axiosInstance from "../enviroment/axiosinstance";
const REST_API_BASE_URL = "api/achievements";

export const updateAchievement = async (achievementId, achievement) => {
  const response = await axiosInstance.put(
    REST_API_BASE_URL + "/" + achievementId,
    achievement,
  );
  return response;
};

export const listAchievements = async () => {
  const response = await axiosInstance.get(REST_API_BASE_URL);
  return response;
};
export const createAchievement = async (achievement) => {
  const response = await axiosInstance.post(REST_API_BASE_URL, achievement);
  return response;
};
export const deleteAchievement = async (achievementId) => {
  const response = await axiosInstance.delete(
    REST_API_BASE_URL + "/" + achievementId,
  );
  return response;
};

export const getAchievement = async (achievementId) => {
  const response = await axiosInstance.get(
    REST_API_BASE_URL + "/" + achievementId,
  );
  return response;
};
