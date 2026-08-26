import { faCheck, faTrashCan, faX } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Button, TextField } from "@mui/material";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import {
  deleteUserById,
  getUser,
  updateUserAccount,
} from "../../services/UsersService";
const DetailsPage = (props) => {
  const { id } = useParams();
  const [username, setUsername] = useState("");
  const [displayName, setDisplayName] = useState("");
  const [openDialog, setOpenDialog] = useState(false);
  const [errors, setErrors] = useState({
    dsiplayName: "",
  });

  useEffect(() => {
    if (id) {
      getUser(id).then((response) => {
        setDisplayName(response.data.displayName);
        console.log(response.data);
      });
    }
  });

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

  const editUserDetails = (e) => {
    e.preventDefault();
    if (validateForm()) {
      const userDetails = {
        username,
        displayName,
      };
      if (id) {
        updateUserAccount(id, userDetails).then((response) => {
          console.log(response.data);
          navigator("/profile");
        });
      }
    }
  };

  const openConfirmationBox = () => {
    setOpenDialog(true);
  };
  const closeConfirmationBox = () => {
    setOpenDialog(false);
  };
  const handleDelete = () => {
    deleteUserById(id).then((response) => {
      console.log(response.data);
    });
  };
  return (
    <div>
      <div>
        <div>
          <div>Edit Profile Details</div>
          <div>
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
          <div className="">
            <Button
              variant="contained"
              color="success"
              onClick={editUserDetails}
            >
              Submit
              <FontAwesomeIcon icon={faCheck}></FontAwesomeIcon>
            </Button>
            <Button variant="contained" color="error">
              Cancel
              <FontAwesomeIcon icon={faX}></FontAwesomeIcon>
            </Button>
          </div>
        </div>
        <div>
          <div>Danger Zone</div>
          <div>
            <button onClick={openConfirmationBox}>
              Terminate Account
              <FontAwesomeIcon icon={faTrashCan} />
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};
export default DetailsPage;
