import { useSnackbar } from "notistack";
import { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import defaultProfilePic from "../../assets/userPicDefault.png";
import { uploadProfilePic } from "../../services/UsersService";
const UploadImage = () => {
  const { enqueueSnackbar } = useSnackbar();
  const id = useParams();
  const navigate = useNavigate();
  const [image, setImage] = useState("");

  function handleImage(e) {
    console.log(e.target.files);
    setImage(URL.createObjectURL(e.target.files[0]));
  }

  const handleSubmit = async (e) => {
    e.preventDefault();
    const response = await uploadProfilePic(id, image);
    enqueueSnackbar(`Welcome ${response.name}`, {
      variant: "success",
      autoHideDuration: 5000,
    });
    navigate("/about");
  };

  return (
    <div>
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
          onClick={handleSubmit}
        >
          Create Account
        </Button>
      </div>
    </div>
  );
};
export default UploadImage;
