import { useState } from "react";
import KatexLabel from "./ProblemScreen/KatexLabel";
import "./formInput.css";
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
        onFocus={inputProps.name === ""}
        className={props.error ? "inputsError" : "inputs"}
      ></input>
      <span className="errorForInputs">{errorMessage}</span>
    </div>
  );
};
export default FormInput;
