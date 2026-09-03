import axiosInstance from "../environment/axiosinstance";
const REST_API_BASE_URL = "/api/user/problems";

export const saveSolvedProblem = async (problemInfo) => {
  const response = await axiosInstance.post(
    REST_API_BASE_URL + "/save",
    problemInfo,
  );
  return response;
};

export const getUserProblems = async (userId, pageNo, pageSize) => {
  const response = await axiosInstance.get(
    REST_API_BASE_URL + "/myproblems/" + userId,
    {
      params: {
        pageNo: pageNo,
        pageSize: pageSize,
      },
    },
  );

  return response;
};

export const getUserProblemById = async (problemId) => {
  const response = await axiosInstance.get(
    REST_API_BASE_URL + "/check/" + problemId,
  );
  return response;
};

export const getCountProblems = async (id) => {
  const response = await axiosInstance.get(
    REST_API_BASE_URL + "/difficulty/" + id,
  );

  return response;
};

export const getCountDistinctProblems = async (id) => {
  const response = await axiosInstance.get(REST_API_BASE_URL + "/count/" + id);

  return response;
};

export const getCountDistinctProblemsByCategory = async (id) => {
  const response = await axiosInstance.get(
    REST_API_BASE_URL + "/category/" + id,
  );

  return response;
};

export const getUserProblemSummaryReport = async (id) => {
  const response = await axiosInstance.get(
    REST_API_BASE_URL + "/summary/" + id,
  );
  return response;
};
