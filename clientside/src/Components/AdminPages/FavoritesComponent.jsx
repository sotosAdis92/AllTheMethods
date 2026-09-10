import { useEffect, useState } from "react";
import { getAllFavorites } from "../../services/FavouritesService";
import ProblemDifficulty from "../ProblemDifficulty/ProblemDifficulty";
import "./FavoritesComponent.css";
const FavoritesComponent = () => {
  const [allFavorites, setAllFavorites] = useState([]);
  useEffect(() => {
    getAllFavorites()
      .then((response) => {
        setAllFavorites(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const listOfAllFavorites = allFavorites.map((favorite) => {
    return (
      <div key={favorite.id} className="favorites-item-table">
        <div>{favorite.userId}</div>
        <div>{favorite.problemId}</div>
        <div>{favorite.dateAdded}</div>
        <div>{favorite.number}</div>
        <div>{favorite.title}</div>
        <div>
          <ProblemDifficulty
            difficulty={favorite.difficulty}
          ></ProblemDifficulty>
        </div>
      </div>
    );
  });
  return (
    <div>
      <div>
        <div className="favoritesHeader favorites-item-table">
          <div>User Id</div>
          <div>Problem Id</div>
          <div>Date Added</div>
          <div>Number</div>
          <div>Title</div>
          <div>Difficulty</div>
        </div>
        {listOfAllFavorites}
      </div>
    </div>
  );
};
export default FavoritesComponent;
