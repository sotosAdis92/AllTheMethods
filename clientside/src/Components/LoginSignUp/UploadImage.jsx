import Button from "@mui/material/Button";
import { useSnackbar } from "notistack";
import { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { saveToken } from "../../environment/common";
import { uploadProfilePic } from "../../services/UsersService";
const UploadImage = () => {
  const { enqueueSnackbar } = useSnackbar();
  const { id } = useParams();
  const navigate = useNavigate();
  const [image, setImage] = useState(null);
  const [file, setFile] = useState(null);

  function handleImage(e) {
    console.log(e.target.files);
    setFile(e.target.files[0]);
    setImage(URL.createObjectURL(e.target.files[0]));
  }

  const handleSubmitImage = async (e) => {
    e.preventDefault();
    const response = await uploadProfilePic(id, file)
      .then((response) => console.log(response))
      .catch((error) => console.log(error));
    console.log(response);
    saveToken(response.jwtToken);
    enqueueSnackbar(`Welcome ${response}`, {
      variant: "success",
      autoHideDuration: 5000,
    });
    navigate("/about");
  };

  return (
    <div className="uploadImageSection">
      {image === null ? (
        <div>
          <div className="image-upload">
            Profile Picture
            <svg
              version="1.0"
              xmlns="http://www.w3.org/2000/svg"
              width="350.000000pt"
              height="350.000000pt"
              viewBox="0 0 350.000000 350.000000"
              preserveAspectRatio="xMidYMid meet"
            >
              <g
                transform="translate(0.000000,350.000000) scale(0.100000,-0.100000)"
                fill="var(--text-primary-color)"
                stroke="none"
              >
                <path
                  d="M1580 3079 c-186 -23 -416 -111 -589 -226 -47 -32 -131 -102 -186
                  -158 -190 -190 -314 -422 -372 -695 -27 -128 -24 -403 5 -525 36 -144 61 -212
                  123 -335 454 -892 1700 -982 2281 -165 101 141 186 341 224 525 25 119 25 382
                  0 500 -41 193 -134 405 -238 545 -65 88 -192 214 -283 283 -140 105 -364 202
                  -550 237 -100 20 -315 27 -415 14z m383 -84 c454 -79 838 -406 981 -835 86
                  -257 90 -538 10 -792 -30 -97 -110 -261 -162 -333 -46 -64 -132 -165 -140
                  -165 -4 0 -20 32 -36 71 -88 218 -289 401 -521 475 -38 12 -70 26 -72 30 -1 5
                  20 24 48 43 80 55 144 139 187 249 22 57 26 83 26 177 0 94 -3 120 -26 182
                  -110 304 -458 448 -741 307 -113 -57 -210 -156 -260 -265 -25 -54 -47 -157
                  -47 -220 0 -71 33 -200 65 -254 40 -69 110 -148 159 -180 25 -16 44 -34 43
                  -39 -2 -4 -34 -18 -72 -30 -237 -76 -432 -254 -522 -477 -15 -38 -31 -69 -35
                  -69 -11 0 -82 86 -136 163 -150 217 -222 451 -222 722 0 148 16 251 61 390
                  119 370 430 682 802 805 182 59 424 77 610 45z m-70 -635 c270 -84 397 -407
                  261 -661 -81 -150 -233 -239 -411 -239 -180 0 -329 98 -412 270 -31 66 -36 86
                  -39 170 -3 78 0 107 17 158 38 113 96 189 191 250 112 73 261 93 393 52z m172
                  -1013 c129 -43 219 -99 315 -196 94 -95 149 -181 182 -284 l22 -68 -29 -24
                  c-110 -90 -288 -186 -425 -230 -123 -39 -236 -55 -388 -55 -275 0 -518 81
                  -747 250 -41 30 -75 62 -75 71 0 22 45 134 76 188 85 146 232 270 394 332 111
                  42 164 49 385 45 197 -2 215 -4 290 -29z"
                />
              </g>
            </svg>
            <label htmlFor="file" className="input-image">
              Upload
            </label>
            <input
              type="file"
              name="file"
              id="file"
              onChange={handleImage}
            ></input>
          </div>
        </div>
      ) : (
        <div>
          <div className="image-upload">
            Profile Picture
            <img src={image} className="image-icon"></img>
            <label htmlFor="file" className="input-image">
              Upload
            </label>
            <input
              type="file"
              name="file"
              id="file"
              onChange={handleImage}
            ></input>
          </div>
        </div>
      )}
      <div className="row">
        <Button
          className="login-button"
          type="submit"
          fullWidth
          variant="contained"
          onClick={handleSubmitImage}
        >
          Create Account
        </Button>
      </div>
    </div>
  );
};
export default UploadImage;
