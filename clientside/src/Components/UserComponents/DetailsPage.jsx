import { faCheck, faTrashCan, faX } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Button, InputLabel, TextField } from "@mui/material";
import { useEffect, useRef, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import imagePencil from "../../assets/pencil.png";
import { removeToken } from "../../environment/common";
import {
  deleteProfilePic,
  deleteUserById,
  getUser,
  updateUserAccount,
  uploadProfilePic,
} from "../../services/UsersService";
import Dialog from "../Util/Dialog";
import defaultProfilePic from "./../../assets/userPicDefault.png";
import ConfirmationDialog from "./ConfirmationDialog";
import "./DetailsPage.css";

const DetailsPage = (props) => {
  const navigator = useNavigate();
  const { id } = useParams();
  const [username, setUsername] = useState("");
  const [displayName, setDisplayName] = useState("");
  const [dialogContent, setDialogContent] = useState(false);
  const [errors, setErrors] = useState({
    displayName: "",
  });
  const [image, setImage] = useState(null);
  const [file, setFile] = useState(null);

  function handleImage(e) {
    console.log(e.target.files);
    setFile(e.target.files[0]);
    setImage(URL.createObjectURL(e.target.files[0]));
  }

  const dialogRef = useRef(null);

  useEffect(() => {
    if (id) {
      getUser(id).then((response) => {
        setDisplayName(response.data.displayName);
        setImage(response.data.image);
        console.log(response.data);
      });
    }
  }, [id]);

  const handleDisplayName = (e) => {
    setDisplayName(e.target.value);
  };

  function validateForm() {
    let valid = true;
    const errorsCopy = { ...errors };
    if (displayName.trim()) {
      errorsCopy.displayName = "";
    } else {
      errorsCopy.displayName = "Username should not be blank";
      valid = false;
    }
    setErrors(errorsCopy);
    return valid;
  }

  const editUserDetails = async (e) => {
    e.preventDefault();
    if (validateForm()) {
      const userDetails = {
        username,
        displayName,
      };
      if (id) {
        if (file) {
          await deleteProfilePic(id);
          await uploadProfilePic(id, file);
        }
        updateUserAccount(id, userDetails).then((response) => {
          navigator("/profile");
        });
      }
    }
  };

  const openConfirmationBox = () => {
    if (!dialogRef.current) {
      return;
    }
    dialogRef.current.hasAttribute("open")
      ? dialogRef.current.close()
      : dialogRef.current.showModal();
  };

  const handleDelete = () => {
    deleteUserById(id).then((response) => {
      openConfirmationBox();
      navigator("/login");
      removeToken();
    });
  };

  const handleCancel = () => {
    navigator("/profile");
  };
  return (
    <div className="edit-profile-container">
      <div className="profile-card">
        <div>
          <div className="section-title">
            <img
              src={imagePencil}
              alt={imagePencil}
              className="imagePencil"
            ></img>
            Edit Profile Details
          </div>
          <div className="row">
            <InputLabel>Display Name</InputLabel>
            <TextField
              type="text"
              placeholder="Enter Display Name"
              name="username"
              value={displayName}
              id={"outlined"}
              error={errors.displayName}
              helperText={errors.displayName}
              onChange={handleDisplayName}
            ></TextField>
          </div>
          <div>
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
            </div>
          </div>
          <div className="buttonsRow">
            <Button
              variant="contained"
              color="success"
              onClick={editUserDetails}
            >
              Submit
              <FontAwesomeIcon icon={faCheck}></FontAwesomeIcon>
            </Button>
            <Button variant="contained" color="error" onClick={handleCancel}>
              Cancel
              <FontAwesomeIcon icon={faX}></FontAwesomeIcon>
            </Button>
          </div>
        </div>
        <div className="danger-zone">
          <div className="danger-zone-title">Danger Zone</div>
          <div>
            <button
              onClick={() => {
                setDialogContent(<ConfirmationDialog></ConfirmationDialog>);
                openConfirmationBox();
              }}
              className="terminate-button"
            >
              Terminate Account
              <FontAwesomeIcon icon={faTrashCan} className="icon-spacing" />
            </button>
          </div>
          <Dialog
            openConfirmationBox={openConfirmationBox}
            handleDelete={handleDelete}
            ref={dialogRef}
          >
            {dialogContent}
          </Dialog>
        </div>
      </div>
    </div>
  );
};
export default DetailsPage;
