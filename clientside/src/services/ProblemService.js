import axios from "axios";
const REST_API_BASE_URL = "http://localhost:8080/api/problems";
export const listProblems = () => {
  return axios.get(REST_API_BASE_URL);
};

export const createProblem = (problem) => {
  axios.post(REST_API_BASE_URL, problem);
};
