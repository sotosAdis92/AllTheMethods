import { useEffect, useState } from "react";
import "./AddToFavoritesStar.css";

const AddToFavouritesStar = (props) => {
  const [favorite, setFavorite] = useState(props.isFavorite || false);
  const [animate, setAnimate] = useState(false);

  useEffect(() => {
    setFavorite(props.isFavorite || false);
  }, [props.isFavorite]);

  function handleFavorite() {
    const favoriteObj = {
      user: props.userId,
      problem: props.problemId,
      date: props.date,
    };
    console.log("Clicked");
    const nextState = !favorite;
    setFavorite(nextState);
    if (nextState) {
      console.log(favoriteObj);
      /*
      saveToFavorites(favoriteObj)
        .then((response) => {
          console.log(response);
        })
        .catch((error) => {
          console.log(error);
        });
        */
      setAnimate(true);
    } else {
      /*
      deleteFromFavorites(props.problemId)
        .then((response) => {
          console.log(response);
        })
        .catch((error) => {
          console.log(error);
        });
        */
      console.log(props.problemId);
    }
    console.log(nextState);
  }
  return (
    <div className="radio">
      <button
        className={`fav-btn ${favorite ? "faved" : ""} ${animate ? "animate-bounce" : ""}`}
        onClick={() => handleFavorite()}
        onAnimationEnd={() => setAnimate(false)}
      >
        <svg width="23" height="23" viewBox="0 0 24 24" className="star">
          <path
            d="M12 2L14.8 8.2L21.5 9.1L16.8 13.6L17.9 20.3L12 17.1L6.1 20.3L7.2 13.6L2.5 9.1L9.2 8.2L12 2Z"
            strokeLinejoin="round"
          />
        </svg>
      </button>
    </div>
  );
};
export default AddToFavouritesStar;
