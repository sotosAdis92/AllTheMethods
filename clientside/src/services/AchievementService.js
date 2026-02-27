import axios from "axios";
import axiosInstance from "../enviroment/axiosinstance";
const REST_API_BASE_URL = "api/achievements";

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

export const listAchievements = async () => {
  const response = await axiosInstance.get(REST_API_BASE_URL);
  return response;
};
