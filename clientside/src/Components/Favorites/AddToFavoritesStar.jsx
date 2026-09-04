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
        <svg width="28" height="28" viewBox="0 0 28 28" className="star">
          <path
            d="M14 2L16.8 8.2L23.5 9.1L18.8 13.6L19.9 20.3L14 17.1L8.1 20.3L9.2 13.6L4.5 9.1L11.2 8.2L14 2Z"
            strokeLinejoin="round"
          />
        </svg>
      </button>
    </div>
  );
};
export default AddToFavouritesStar;
