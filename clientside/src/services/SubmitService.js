import axiosInstance from "../enviroment/axiosinstance";
const REST_API_BASE_URL = "/api/submissions";

export const sendSubmission = async (submission) => {
  const response = await axiosInstance.post(REST_API_BASE_URL, submission);
  return response;
};
