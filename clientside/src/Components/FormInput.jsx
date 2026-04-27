import { useState } from "react";
import "../FormInputs.css";
const FormInput = (props) => {
  const { label, onChange, errorMessage, ...inputProps } = props;
  const [focused, setFocused] = useState(false);
  const handleFocus = (e) => {
    e.preventDefault;
    setFocused(true);
  };
  console.log(props.isSolved);
  return (
    <div className="formInput">
      <label>{label}</label>
      <input
        {...inputProps}
        onChange={onChange}
        maxLength={5}
        onBlur={handleFocus}
        focused={focused.toString()}
      ></input>
      <span className="errorForInputs">{errorMessage}</span>
    </div>
  );
};
export default FormInput;
