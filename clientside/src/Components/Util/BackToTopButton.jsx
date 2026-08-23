import { useEffect, useState } from "react";
import arrowUp from "../../assets/arrowUpS.png";
import "./BackToTopButton.css";
const BackToTopButton = () => {
  const [backToTopButton, setBackToTopButton] = useState(false);
  useEffect(() => {
    window.addEventListener("scroll", () => {
      if (window.scrollY > 100) {
        setBackToTopButton(true);
      } else {
        setBackToTopButton(false);
      }
    });
  }, []);
  const scrollUp = () => {
    window.scrollTo({
      top: 0,
      behavior: "smooth",
    });
  };

  return (
    <div className="backToTopButton">
      <div>
        {backToTopButton && (
          <button onClick={scrollUp}>
            <img src={arrowUp} alt={arrowUp}></img>
          </button>
        )}
      </div>
    </div>
  );
};
export default BackToTopButton;
