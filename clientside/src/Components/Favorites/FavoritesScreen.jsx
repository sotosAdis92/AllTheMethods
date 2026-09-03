import { useEffect, useState } from "react";
import { getAllUserFavorites } from "../../services/FavouritesService";
const FavoritesScreen = (props) => {
  const [favorites, setFavorites] = useState([]);
  const userId = props.userId;
  console.log(userId);
  useEffect(() => {
    getAllUserFavorites(userId)
      .then((response) => {
        setFavorites(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const listOfFavorites = favorites.map((favourite) => {
    <div>
      <div></div>
    </div>;
  });

  return (
    <div className="favoritesContainerDiv">
      <h2>Favorites</h2>
      <div>{listOfFavorites}</div>
    </div>
  );
};
export default FavoritesScreen;
