const FormInput = (props) => {
  const { label, onChange, errorMessage, id, i, ...inputProps } = props;
  return (
    <div className="formInput">
      <label>{label}</label>
      <input {...inputProps} onChange={onChange}></input>
      <span>{errorMessage}</span>
    </div>
  );
};
export default FormInput;
