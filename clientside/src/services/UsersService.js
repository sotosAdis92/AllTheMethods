import axiosInstance from "../environment/axiosinstance";
const REST_API_BASE_URL = "api/user";

export const getUser = async () => {
  const response = axiosInstance.get(REST_API_BASE_URL + "/username");
  return response;
};
