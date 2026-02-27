import axios from "axios";
const REST_API_BASE_URL =
  "http://localhost:8080/api/userAchievements/myAchievements";
export const listUsersAchievements = () => {
  return axios.get(REST_API_BASE_URL);
};
