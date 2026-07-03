import axiosInstance from "../environment/axiosinstance";
const REST_API_BASE_URL = "/api/problems";

export const getProblem = async (problemId) => {
  const response = await axiosInstance.get(REST_API_BASE_URL + "/" + problemId);
  return response;
};

export const updateProblem = async (problemId, problem) => {
  const response = await axiosInstance.put(
    REST_API_BASE_URL + "/" + problemId,
    problem,
  );
  return response;
};

export const deleteProblem = async (problemId) => {
  const response = await axiosInstance.delete(
    REST_API_BASE_URL + "/" + problemId,
  );
  return response;
};

export const createProblem = async (problem) => {
  const response = await axiosInstance.post(REST_API_BASE_URL, problem);
  return response;
};

export const listProblems = async () => {
  const response = await axiosInstance.get(REST_API_BASE_URL);
  return response;
};

export const getProblemsByCategory = async () => {};

export const getProblemsByDifficulty = async () => {};
