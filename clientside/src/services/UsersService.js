import axiosInstance from "../environment/axiosinstance";
const REST_API_BASE_URL = "api/v1/user";

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

export const updateUserAccount = async (id, userDetails) => {
  const response = axiosInstance.put(
    REST_API_BASE_URL + "/details/" + id,
    userDetails,
  );
  return response;
};

export const uploadProfilePic = async (id, image) => {
  const formData = new FormData();
  formData.append("file", image);
  const response = axiosInstance.post(
    `${REST_API_BASE_URL}/${id}/image`,
    formData,
    { headers: {} },
  );
  console.log(response);
  return response;
};

export const deleteProfilePic = async (id) => {
  const response = await axiosInstance.delete(
    `${REST_API_BASE_URL}/${id}/image`,
  );
  return response;
};
