import axios from "axios";
const REST_API_BASE_URL = "http://localhost:8080/api/achievements";
export const listAchievements = () => {
  return axios.get(REST_API_BASE_URL);
};

export const createAchievement = (achievement) => {
  return axios.post(REST_API_BASE_URL, achievement);
};

export const getAchievemet = (achievementId) => {
  return axios.get(REST_API_BASE_URL + "/" + achievementId);
};

export const updateAchievement = (achievementId, achievement) => {
  return axios.put(REST_API_BASE_URL + "/" + achievementId, achievement);
};

export const deleteAchievement = (achievementId) => {
  return axios.delete(REST_API_BASE_URL + "/" + achievementId);
};
