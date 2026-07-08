import img1 from "../../assets/userPicDefault.png";
const UserIcon = (props) => {
  return (
    <>
      <div className="userDetails">
        <img src={img1} alt="User Avatar"></img>
        <div>{props.displayName}</div>
      </div>
    </>
  );
};
export default UserIcon;
