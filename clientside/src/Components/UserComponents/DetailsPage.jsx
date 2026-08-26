import { faCheck, faTrashCan, faX } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Button, TextField } from "@mui/material";
import { useState } from "react";
const DetailsPage = (props) => {
  const [username, setUsername] = useState("");
  const [errors, setErrors] = useState({
    username: "",
  });
  const handleUsername = (e) => {
    setUsername(e.target.value);
  };
  function validateForm() {
    let valid = true;
    const errorsCopy = { ...errors };
    if (username.trim()) {
      errorsCopy.username = "";
    } else {
      errorsCopy.username = "Username should not be blank";
    }
  }
  return (
    <div>
      <div>
        <div>
          <div>Edit Profile Details</div>
          <div>
            <TextField
              type="text"
              placeholder="Enter Username"
              name="username"
              value={username}
              id={"outlined"}
              error={errors.username}
              helperText={errors.username}
              onChange={handleUsername}
            ></TextField>
          </div>
          <div className="">
            <Button
              variant="contained"
              color="success"
              onClick={handleUsername}
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
