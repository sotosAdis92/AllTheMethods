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
  console.log(response);
  return response;
};

export const getUserProblemById = async (problemId, userId) => {
  const response = await axiosInstance.get(
    REST_API_BASE_URL + "/check/" + problemId,
    problemId,
  );
  return response;
};

export const getCountProblems = async (id) => {
  const response = await axiosInstance.get(
    REST_API_BASE_URL + "/difficulty/" + id,
  );
  console.log(response);
  return response;
};

export const getCountDistinctProblems = async (id) => {
  const response = await axiosInstance.get(REST_API_BASE_URL + "/count/" + id);
  console.log(response);
  return response;
};

export const getCountDistinctProblemsByCategory = async (id) => {
  console.log("function called");
  const response = await axiosInstance.get(
    REST_API_BASE_URL + "/category/" + id,
  );
  console.log("s", response);
  return response;
};
