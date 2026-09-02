import axiosInstance from "../environment/axiosinstance";
const REST_API_BASE_URL = "/api/favourites";

export const saveToFavourites = async (favourite) => {
  const response = await axiosInstance.post(REST_API_BASE_URL, favourite);
  return response;
};

export const deleteFromFavourites = async (id) => {
  const response = await axiosInstance.delete(REST_API_BASE_URL + "/" + id);
  return response;
};

export const getAllUserFavourites = async (id) => {
  const response = await axiosInstance.get(
    REST_API_BASE_URL + "/user/all/" + id,
  );
  return response;
};

export const getAllFavourites = async () => {
  const response = await axiosInstance.get(REST_API_BASE_URL + "/all");
  return response;
};
