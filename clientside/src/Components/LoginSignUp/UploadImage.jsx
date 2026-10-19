import Button from "@mui/material/Button";
import { useSnackbar } from "notistack";
import { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { saveToken } from "../../environment/common";
import { uploadProfilePic } from "../../services/UsersService";
import defaultProfilePic from "./../../assets/userPicDefault.png";
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
            <img src={defaultProfilePic} className="image-icon"></img>
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
