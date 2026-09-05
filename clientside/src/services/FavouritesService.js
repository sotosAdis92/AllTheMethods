import axiosInstance from "../environment/axiosinstance";
const REST_API_BASE_URL = "/api/favourites";

export const saveToFavorites = async (favourite) => {
  const response = await axiosInstance.post(REST_API_BASE_URL, favourite);
  return response;
};

export const deleteFromFavorites = async (id) => {
  const response = await axiosInstance.delete(REST_API_BASE_URL + "/" + id);
  return response;
};

export const getAllUserFavorites = async (userId) => {
  const response = await axiosInstance.get(
    REST_API_BASE_URL + "/user/all/" + userId,
  );
  return response;
};

export const getAllFavorites = async () => {
  const response = await axiosInstance.get(REST_API_BASE_URL + "/all");
  return response;
};
