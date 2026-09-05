import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getAllUserFavorites } from "../../services/FavouritesService";
import ProblemDifficulty from "../ProblemDifficulty";
import "./FavoritesScreen.css";
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

  const listOfFavorites = favorites.map((favorite) => (
    <div key={favorite.id} className="favoriteItem">
      <div className="numberTitleAndDifficulty">
        {favorite.number}. {favorite.title}
        <div className="difficultyDivSubmission">
          <ProblemDifficulty
            difficulty={favorite.difficulty}
          ></ProblemDifficulty>
        </div>
      </div>
      <div>{favorite.dateAdded}</div>
    </div>
  ));

  return (
    <div className="viewFavorites">
      <div className="favoritesContainerDiv">
        <h2 className="favoritesHeading">Favorites</h2>
        <div className="favoritesList">{listOfFavorites}</div>
      </div>
    </div>
  );
};
export default FavoritesScreen;
