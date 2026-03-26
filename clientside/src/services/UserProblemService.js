import axiosInstance from "../enviroment/axiosinstance";
const REST_API_BASE_URL = "/api/userProblems/myProblems";

export const getUserProblems = async () => {
  const response = await axiosInstance.get(REST_API_BASE_URL);
  return response;
};
