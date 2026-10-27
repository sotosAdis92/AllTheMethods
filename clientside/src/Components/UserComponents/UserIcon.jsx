import { faPencil } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getUserTotalPoints } from "../../services/UserProblemService";
import defaultProfilePic from "./../../assets/userPicDefault.png";
import "./UserIcon.css";

const UserIcon = (props) => {
  const [points, SetPoints] = useState(0);
  useEffect(() => {
    getUserTotalPoints(props.userId);
  });
  getUserTotalPoints(props.userId).then((response) => {
    SetPoints(response.data);
  });

  const navigator = useNavigate();
  const navigateToEdit = () => {
    navigator(`/profile/details/${props.userId}`);
  };
  console.log(props);
  return (
    <>
      <div className="userIconWrapper">
        <div className="userDetails">
          <img
            src={props.image === null ? defaultProfilePic : props.image}
          ></img>
          <div className="displayAndUsername">
            <div className="displayName">{props.displayName}</div>
            <div className="username">{props.username}</div>
            <div>
              <div id="points">Points: {points}</div>
            </div>
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
