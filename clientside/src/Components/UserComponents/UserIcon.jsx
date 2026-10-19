import { faPencil } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { useNavigate } from "react-router-dom";
import "./UserIcon.css";

const UserIcon = (props) => {
  const navigator = useNavigate();
  const navigateToEdit = () => {
    navigator(`/profile/details/${props.userId}`);
  };
  console.log(props);
  return (
    <>
      <div className="userIconWrapper">
        <div className="userDetails">
          <img src={props.image} alt="User Avatar"></img>
          <div className="displayAndUsername">
            <div className="displayName">{props.displayName}</div>
            <div className="username">{props.username}</div>
          </div>
        </div>
        <div>
          <button className="editAccountButton" onClick={navigateToEdit}>
            Edit Profile
            <FontAwesomeIcon icon={faPencil}></FontAwesomeIcon>
          </button>
        </div>
      </div>
    </>
  );
};
export default UserIcon;
