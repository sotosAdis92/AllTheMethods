import img from "../../assets/arrowup.png";
const SubmitButton = ({ isButtonDisabled, onClick }) => {
  return (
    <button
      type="button"
      disabled={isButtonDisabled}
      onClick={onClick}
      className="submitButton"
    >
      <img src={img}></img>
      Submit
    </button>
  );
};
export default SubmitButton;
