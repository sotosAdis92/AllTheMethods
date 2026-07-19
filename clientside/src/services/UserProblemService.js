import axiosInstance from "../environment/axiosinstance";
const REST_API_BASE_URL = "/api/user/problems";

export const saveSolvedProblem = async (problemInfo) => {
  const response = await axiosInstance.post(
    REST_API_BASE_URL + "/save",
    problemInfo,
  );
  return response;
};

export const getUserProblems = async (userId) => {
  const response = await axiosInstance.get(
    REST_API_BASE_URL + `/myproblems/${userId}`,
  );
  return response;
};

export const getUserProblemById = async (problemId) => {
  const response = await axiosInstance.get(
    REST_API_BASE_URL + "/" + problemId,
    problemId,
  );
  return response;
};
