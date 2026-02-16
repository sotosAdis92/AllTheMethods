import axios from "axios";
const REST_API_BASE_URL = "http://localhost:8080/api/problems";
export const listProblems = () => {
  return axios.get(REST_API_BASE_URL);
};

export const createProblem = (problem) => {
  return axios.post(REST_API_BASE_URL, problem);
};

export const getProblem = (problemId) => {
  return axios.get(REST_API_BASE_URL + "/" + problemId);
};

export const updateProblem = (problemId, problem) => {
  return axios.put(REST_API_BASE_URL + "/" + problemId, problem);
};

export const deleteProblem = (problemId) => {
  return axios.delete(REST_API_BASE_URL + "/" + problemId);
};
