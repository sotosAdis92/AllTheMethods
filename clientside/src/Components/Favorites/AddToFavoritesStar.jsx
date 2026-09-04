import { useState } from "react";
import "./AddToFavoritesStar.css";

const AddToFavouritesStar = () => {
  const [favourite, setFavourite] = useState(false);
  const [animate, setAnimate] = useState(false);

  function handleFavorite() {
    console.log("Clicked");
    const nextState = !favourite;
    setFavourite(nextState);
    if (nextState) {
      setAnimate(true);
    }
  }
  return (
    <div className="radio">
      <button
        className={`fav-btn ${favourite ? "faved" : ""} ${animate ? "animate-bounce" : ""}`}
        onClick={() => handleFavorite()}
        onAnimationEnd={() => setAnimate(false)}
      >
        <svg width="22" height="22" viewBox="0 0 24 24" className="star">
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
