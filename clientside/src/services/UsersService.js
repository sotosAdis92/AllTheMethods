import axiosInstance from "../environment/axiosinstance";
const REST_API_BASE_URL = "api/user";

export const getUser = async () => {
  const response = axiosInstance.get(REST_API_BASE_URL + "/username");
  return response;
};

export const getAllUsers = async () => {
  const response = axiosInstance.get(REST_API_BASE_URL);
  return response;
};

export const deleteUserById = async (id) => {
  const response = axiosInstance.delete(REST_API_BASE_URL + `/` + id);
  return response;
};
