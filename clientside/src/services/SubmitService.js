import axiosInstance from "../environment/axiosinstance";
const REST_API_BASE_URL = "/api/submissions";

export const saveSubmission = async (submission) => {
  const response = await axiosInstance.post(REST_API_BASE_URL, submission);
  return response;
};

export const sendSubmissionData = async (data) => {
  const response = await axiosInstance.post(REST_API_BASE_URL + "/data", data);
  return response;
};

export const sendRegulaFalsiData = async (data) => {
  const response = await axiosInstance.post(
    REST_API_BASE_URL + "/regulaFalsi",
    data,
  );
  return response;
};

export const sendNewtonRaphsonData = async (data) => {
  const response = await axiosInstance.post(
    REST_API_BASE_URL + "/newtonRaphson",
    data,
  );
  return response;
};

export const sendDiakritiNewtonRaphsonData = async (data) => {
  const response = await axiosInstance.post(
    REST_API_BASE_URL + "/diakritiNewtonRaphson",
    data,
  );
  return response;
};

export const sendFixedPointData = async (data) => {
  const response = await axiosInstance.post(
    REST_API_BASE_URL + "/fixedPoint",
    data,
  );
  return response;
};
