const FormInput = (props) => {
  const { label, onChange, id, i, ...inputProps } = props;
  return (
    <div className="formInput">
      <label>{label}</label>
      <input {...inputProps} onChange={onChange}></input>
    </div>
  );
};
export default FormInput;
