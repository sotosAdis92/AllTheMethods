import "../FormInputs.css";
const FormInput = (props) => {
  const { label, onChange, errorMessage, id, i, ...inputProps } = props;
  return (
    <div className="formInput">
      <label>{label}</label>
      <input {...inputProps} onChange={onChange} maxLength={5}></input>
      <span className="errorForInputs">{errorMessage}</span>
    </div>
  );
};
export default FormInput;
