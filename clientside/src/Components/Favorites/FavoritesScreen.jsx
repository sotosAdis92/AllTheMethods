import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getAllUserFavorites } from "../../services/FavouritesService";
const FavoritesScreen = (props) => {
  const [favorites, setFavorites] = useState([]);
  const { id } = useParams();
  useEffect(() => {
    if (id) {
      getAllUserFavorites(id)
        .then((response) => {
          setFavorites(response.data);
          console.log(response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    }
  }, []);

  const listOfFavorites = favorites.map((favourite) => (
    <div>
      <div>{}</div>
      <div>{}</div>
      <div>{}</div>
    </div>
  ));

  return (
    <div className="favoritesContainerDiv">
      <h2>Favorites</h2>
      <div>{listOfFavorites}</div>
    </div>
  );
};
export default FavoritesScreen;
