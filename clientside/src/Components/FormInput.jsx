const FormInput = (props) => {
  return (
    <div className="formInput">
      <label></label>
      <input
        placeholder={props.placeholder}
        maxLength={5}
        type="number"
        onChange={(e) => props.handleInput(props.i, e)}
      ></input>
    </div>
  );
};
export default FormInput;
