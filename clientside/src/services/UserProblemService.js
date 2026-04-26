import axiosInstance from "../environment/axiosinstance";
const REST_API_BASE_URL = "/api/userProblems";

export const saveSolvedProblem = async (problemInfo) => {
  const response = await axiosInstance.post(
    REST_API_BASE_URL + "/saveProblem",
    problemInfo,
  );
  return response;
};

export const getUserProblems = async () => {
  const response = await axiosInstance.get(REST_API_BASE_URL + "/myProblems");
  return response;
};
