import axios from "axios";
const REST_API_BASE_URL = "http://localhost:8080/api/achievements";
export const listAchievements = () => {
  return axios.get(REST_API_BASE_URL);
};

export const createAchievement = (achievement) => {
  return axios.post(REST_API_BASE_URL, achievement);
};
