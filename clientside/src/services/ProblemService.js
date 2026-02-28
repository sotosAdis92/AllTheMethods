import axios from "axios";
import axiosInstance from "../enviroment/axiosinstance";
const REST_API_BASE_URL = "/api/problems";

export const getProblem = (problemId) => {
  return axios.get(REST_API_BASE_URL + "/" + problemId);
};

export const updateProblem = (problemId, problem) => {
  return axios.put(REST_API_BASE_URL + "/" + problemId, problem);
};

export const deleteProblem = (problemId) => {
  return axios.delete(REST_API_BASE_URL + "/" + problemId);
};

export const createProblem = async (problem) => {
  const response = await axiosInstance.post(REST_API_BASE_URL, problem);
  return response;
};

export const listProblems = async () => {
  const response = await axiosInstance.get(REST_API_BASE_URL);
  return response;
};
