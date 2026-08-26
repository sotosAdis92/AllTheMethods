import { useNavigate } from "react-router-dom";
import img1 from "../../assets/userPicDefault.png";
const UserIcon = (props) => {
  const navigator = useNavigate();
  const navigateToEdit = () => {
    navigator(`/profile/details/${props.id}`);
  };
  return (
    <>
      <div className="userIconWrapper"></div>
      <div className="userDetails">
        <img src={img1} alt="User Avatar"></img>
        <div className="displayAndUsername">
          <div className="displayName">{props.displayName}</div>
          <div className="username">{props.username}</div>
        </div>
      </div>
      <div>
        <button className="editAccountButton" onClick={navigateToEdit}>
          Edit Profile
        </button>
      </div>
    </>
  );
};
export default UserIcon;
