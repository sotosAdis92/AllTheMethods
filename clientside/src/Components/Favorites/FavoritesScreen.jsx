import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getAllUserFavorites } from "../../services/FavouritesService";
import ProblemDifficulty from "../ProblemDifficulty/ProblemDifficulty";
import "./FavoritesScreen.css";
const FavoritesScreen = (props) => {
  const [favorites, setFavorites] = useState([]);
  const [count, setCount] = useState(0);
  const [pageNumber, setPageNumber] = useState(1);
  const [pageSize, setPageSize] = useState(20);
  const { id } = useParams();
  useEffect(() => {
    if (id) {
      getAllUserFavorites(id)
        .then((response) => {
          setCount(response.data.totalElements);
          setFavorites(response.data.content);
          console.log(response.data.content);
          console.log(response.data.totalElements);
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
    <div className="containerDiv">
      {count > 0 ? (
        <div className="viewFavorites">
          <div className="favoritesContainerDiv">
            <div className="imageAndText">
              <div className="plainText">
                <h2 className="favoritesHeading">
                  <svg
                    width="28"
                    height="28"
                    viewBox="0 0 24 24"
                    xmlns="http://www.w3.org/2000/svg"
                    style={{
                      fill: "#000000",
                      stroke: "none",
                      flexShrink: 0,
                    }}
                  >
                    <path d="M22,9.67A1,1,0,0,0,21.14,9l-5.69-.83L12.9,3a1,1,0,0,0-1.8,0L8.55,8.16,2.86,9a1,1,0,0,0-.81.68,1,1,0,0,0,.25,1l4.13,4-1,5.68a1,1,0,0,0,.4,1,1,1,0,0,0,1.05.07L12,18.76l5.1,2.68a.93.93,0,0,0,.46.12,1,1,0,0,0,.59-.19,1,1,0,0,0,.4-1l-1-5.68,4.13-4A1,1,0,0,0,22,9.67Zm-6.15,4a1,1,0,0,0-.29.89l.72,4.19-3.76-2a1,1,0,0,0-.94,0l-3.76,2,.72-4.19a1,1,0,0,0-.29-.89l-3-3,4.21-.61a1,1,0,0,0,.76-.55L12,5.7l1.88,3.82a1,1,0,0,0,.76.55l4.21.61Z" />
                  </svg>
                  <div className="headerText">Favorites</div>
                </h2>
                <div className="favoritesCounter">
                  <div className="textDiv">
                    Total Favorites:
                    <div className="favoritesCount">
                      {count}
                      <div className="favoriteSupperText">Favorites</div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div className="favoritesList">{listOfFavorites}</div>
          </div>
        </div>
      ) : (
        <div className="viewFavorites">
          <div className="favoritesContainerDiv">
            <h2 className="favoritesHeading">Favorites</h2>
            <div className="favoritesCounter">Total Favorites: {count}</div>
            <div className="countZeroImage">
              <svg
                width="28"
                height="28"
                viewBox="0 0 24 24"
                xmlns="http://www.w3.org/2000/svg"
                style={{
                  fill: "#000000",
                  stroke: "none",
                  flexShrink: 0,
                }}
              >
                <path d="M22,9.67A1,1,0,0,0,21.14,9l-5.69-.83L12.9,3a1,1,0,0,0-1.8,0L8.55,8.16,2.86,9a1,1,0,0,0-.81.68,1,1,0,0,0,.25,1l4.13,4-1,5.68a1,1,0,0,0,.4,1,1,1,0,0,0,1.05.07L12,18.76l5.1,2.68a.93.93,0,0,0,.46.12,1,1,0,0,0,.59-.19,1,1,0,0,0,.4-1l-1-5.68,4.13-4A1,1,0,0,0,22,9.67Zm-6.15,4a1,1,0,0,0-.29.89l.72,4.19-3.76-2a1,1,0,0,0-.94,0l-3.76,2,.72-4.19a1,1,0,0,0-.29-.89l-3-3,4.21-.61a1,1,0,0,0,.76-.55L12,5.7l1.88,3.82a1,1,0,0,0,.76.55l4.21.61Z" />
              </svg>
            </div>
            <p className="noProblems">No Favorites Yet!</p>
          </div>
        </div>
      )}
    </div>
  );
};
export default FavoritesScreen;
