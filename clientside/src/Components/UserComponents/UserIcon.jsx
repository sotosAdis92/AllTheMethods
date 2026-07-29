import img1 from "../../assets/userPicDefault.png";
const UserIcon = (props) => {
  return (
    <>
      <div className="userDetails">
        <img src={img1} alt="User Avatar"></img>
        <div className="displayAndUsername">
          <div className="displayName">{props.displayName}</div>
          <div className="username">{props.username}</div>
        </div>
      </div>
    </>
  );
};
export default UserIcon;
