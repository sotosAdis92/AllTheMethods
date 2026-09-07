import { useEffect, useState } from "react";
import { getAllFavorites } from "../../services/FavouritesService";
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
      <div key={favorite.id}>
        <div>{favorite.userId}</div>
        <div>{favorite.problemId}</div>
        <div>{favorite.dateAdded}</div>
        <div>{favorite.number}</div>
        <div>{favorite.title}</div>
        <div>{favorite.difficulty}</div>
      </div>
    );
  });
  return (
    <div>
      <div>
        <div className="">
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
