import { faCheck, faTrashCan, faX } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Button, TextField } from "@mui/material";
import { useState } from "react";
import { useParams } from "react-router-dom";
import updateUserAccount from "../../services/UsersService";
const DetailsPage = (props) => {
  const { id } = useParams();
  const [username, setUsername] = useState("");
  const [displayName, setDisplayName] = useState("");
  const [errors, setErrors] = useState({
    dsiplayName: "",
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
            <button>
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
