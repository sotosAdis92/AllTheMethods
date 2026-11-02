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
                      fill: "var(--text-primary-color)",
                      stroke: "none",
                      flexShrink: 0,
                    }}
                  >
                    <path
                      d="M22,9.67A1,1,0,0,0,21.14,9l-5.69-.83L12.9,3a1,1,0,0,0-1.8,0L8.55,8.16,2.86,9a1,1,0,0,0-.81.68,1,1,0,0,0,
                    .25,1l4.13,4-1,5.68a1,1,0,0,0,.4,1,1,1,0,0,0,1.05.07L12,18.76l5.1,2.68a.93.93,0,0,0,.46.12,1,1,0,0,0,.59-.19,
                    1,1,0,0,0,.4-1l-1-5.68,4.13-4A1,1,0,0,0,22,9.67Zm-6.15,4a1,1,0,0,0-.29.89l.72,4.19-3.76-2a1,1,0,0,0-.94,0l-3.76
                    ,2,.72-4.19a1,1,0,0,0-.29-.89l-3-3,4.21-.61a1,1,0,0,0,.76-.55L12,5.7l1.88,3.82a1,1,0,0,0,.76.55l4.21.61Z"
                    />
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
            <div className="favoriteList">{listOfFavorites}</div>
          </div>
        </div>
      ) : (
        <div className="viewFavorites">
          <div className="favoritesContainerDiv">
            <h2 className="favoritesHeading">Favorites</h2>
            <div className="favoritesCounter">Total Favorites: {count}</div>
            <svg
              version="1.0"
              xmlns="http://www.w3.org/2000/svg"
              width="30px"
              height="30px"
              viewBox="0 0 494.000000 505.000000"
              preserveAspectRatio="xMidYMid meet"
              className="countZeroImage"
            >
              <g
                transform="translate(0.000000,505.000000) scale(0.100000,-0.100000)"
                fill="var(--text-primary-color)"
                stroke="none"
              >
                <path
                  d="M2415 4792 c-46 -29 -89 -82 -151 -189 -173 -296 -364 -622 -499
                -848 -55 -93 -125 -211 -155 -262 -63 -106 -36 -93 -290 -138 -74 -13 -211
                -37 -305 -54 -93 -17 -306 -55 -472 -85 -320 -57 -376 -74 -446 -136 -51 -44
                -67 -79 -67 -142 0 -100 12 -114 689 -838 85 -91 194 -207 243 -258 65 -70 88
                -101 88 -120 0 -30 -17 -163 -55 -432 -102 -731 -108 -803 -81 -893 31 -103
                94 -149 207 -149 108 0 135 9 419 145 63 30 165 78 227 106 62 28 154 71 205
                95 324 153 504 236 514 236 6 0 97 -43 444 -208 52 -25 140 -66 195 -92 106
                -50 194 -92 415 -197 164 -78 231 -97 322 -91 81 6 125 34 156 101 37 80 42
                139 22 282 -10 72 -23 173 -30 225 -18 151 -68 537 -80 625 -10 73 -29 240
                -30 257 0 3 60 71 133 150 72 79 150 163 172 187 22 24 49 53 61 65 11 12 94
                102 185 201 160 176 242 265 266 290 54 56 157 184 172 214 80 156 -24 293
                -254 336 -124 22 -269 49 -670 120 -203 36 -413 74 -465 84 l-95 17 -137 235
                c-76 129 -172 293 -214 364 -42 72 -92 157 -111 190 -223 385 -332 561 -365
                588 -48 39 -119 47 -163 19z m136 -365 c29 -51 120 -207 202 -347 83 -140 158
                -268 167 -285 10 -16 42 -73 72 -125 30 -52 79 -136 109 -186 30 -50 79 -134
                109 -186 l55 -95 170 -31 c94 -18 244 -45 335 -62 91 -16 291 -52 445 -80 154
                -29 311 -56 350 -62 38 -5 82 -16 98 -24 25 -13 27 -17 15 -32 -22 -30 -93
                -108 -543 -597 -242 -263 -445 -486 -452 -495 -9 -13 -6 -66 18 -251 17 -129
                39 -301 49 -384 10 -82 34 -275 54 -428 20 -154 33 -283 30 -289 -10 -15 -67
                -3 -137 30 -34 17 -159 76 -277 132 -118 56 -246 117 -285 135 -38 18 -173 82
                -300 143 -319 152 -341 162 -347 162 -7 0 -491 -223 -663 -305 -66 -32 -138
                -65 -161 -75 -23 -10 -137 -63 -255 -118 -118 -55 -230 -104 -250 -107 -31 -6
                -37 -4 -42 15 -6 24 12 205 48 460 13 96 35 258 49 360 14 102 35 258 47 347
                l22 161 -27 34 c-16 18 -92 101 -169 183 -320 342 -394 421 -610 654 -125 134
                -224 247 -222 251 7 12 112 35 310 70 99 17 236 42 305 55 69 13 281 52 472
                86 l348 63 136 230 c76 127 175 293 221 370 45 76 83 140 83 143 0 3 8 17 19
                31 10 15 28 43 39 62 11 19 37 65 58 102 22 36 82 140 134 231 67 116 98 162
                106 156 7 -6 36 -51 65 -102z"
                />
              </g>
            </svg>
            <p className="noProblems">No Favorites Yet!</p>
            <p className="linkToProblemsList">
              Want to add problems to favorites?{" "}
              <a href="/problems" className="link">
                Problems List
              </a>
            </p>
          </div>
        </div>
      )}
    </div>
  );
};
export default FavoritesScreen;
