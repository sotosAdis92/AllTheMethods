import axiosInstance from "../enviroment/axiosinstance";
const REST_API_BASE_URL = "api/user";

export const getUser = async () => {
  const response = axiosInstance.get(REST_API_BASE_URL);
  return response;
};
