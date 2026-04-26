import axiosInstance from "../environment/axiosinstance";

export const signup = async (signupDTO) => {
  const response = await axiosInstance.post("api/auth/signup", signupDTO);
  return response;
};
export const login = async (loginDTO) => {
  const response = await axiosInstance.post("api/auth/login", loginDTO);
  return response;
};
