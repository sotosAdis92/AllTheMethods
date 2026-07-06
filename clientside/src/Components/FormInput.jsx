import { useState } from "react";
import "../FormInputs.css";
import KatexLabel from "./ProblemScreen/KatexLabel";
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
      <KatexLabel latex={label}></KatexLabel>
      <input
        {...inputProps}
        onChange={onChange}
        maxLength={5}
        onBlur={handleFocus}
        focused={focused.toString()}
        className={props.generalError ? "inputsError" : "inputs"}
      ></input>
      <span className="errorForInputs">{errorMessage}</span>
    </div>
  );
};
export default FormInput;
