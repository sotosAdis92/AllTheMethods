import axiosInstance from "../environment/axiosinstance";
const REST_API_BASE_URL = "/api/submissions";

export const saveSubmission = async (submission) => {
  const response = await axiosInstance.post(REST_API_BASE_URL, submission);
  return response;
};

export const sendSubmissionData = async (data) => {
  const response = await axiosInstance.post(
    REST_API_BASE_URL + "/bisection",
    data,
  );
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

export const sendTrapezodialData = async (data) => {
  const response = await axiosInstance.post(
    REST_API_BASE_URL + "/trapezodialRule",
    data,
  );
  return response;
};

export const sendSimposonData = async (data) => {
  const response = await axiosInstance.post(
    REST_API_BASE_URL + "/simposon",
    data,
  );
  return response;
};

export const sendThreePointDerivativeData = async (data) => {
  const response = await axiosInstance.post(
    REST_API_BASE_URL + "/threePointsDer",
    data,
  );
  return response;
};

export const sendFivePointDerivativeData = async (data) => {
  console.log(data);
  const response = await axiosInstance.post(
    REST_API_BASE_URL + "/fivePointsDer",
    data,
  );
  return response;
};

export const sendRichardsonData = async (data) => {
  const response = await axiosInstance.post(
    REST_API_BASE_URL + "/richardson",
    data,
  );
  return response;
};

export const sendRungeKuttaData = async (data) => {
  const response = await axiosInstance.post(
    REST_API_BASE_URL + "/rungeKutta",
    data,
  );
  return response;
};

export const sendImprovedEuler = async (data) => {
  const response = await axiosInstance.post(
    REST_API_BASE_URL + "/improvedEuler",
    data,
  );
  return response;
};

export const sendDirectEuler = async (data) => {
  const response = await axiosInstance.post(
    REST_API_BASE_URL + "/directEuler",
    data,
  );
  return response;
};

export const sendRungeKuttaNystrom = async (data) => {
  const response = await axiosInstance.post(
    REST_API_BASE_URL + "/rungeKuttaN",
    data,
  );
  return response;
};

export const getAllUserSubmissions = async (id, pageNo, pageSize, sortDir) => {
  const response = await axiosInstance.get(REST_API_BASE_URL + "/user/" + id, {
    params: {
      pageNo: pageNo,
      pageSize: pageSize,
      sortDir: sortDir,
    },
  });
  return response;
};

export const getAllSubmissions = async () => {
  const response = await axiosInstance.get(REST_API_BASE_URL + "/admin");
  console.log(response);
  return response;
};
