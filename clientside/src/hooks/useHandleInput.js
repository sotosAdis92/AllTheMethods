import { useState } from "react";

export default function useHandleInput() {
  const [input, setInput] = useState([]);
  const [inp, setInputI] = useState([]);
  const [generalError, setGeneralError] = useState("");

  const handleInput = (i, e) => {
    const value = Number(e.target.value);
    const indexOfNumber = input.findIndex(
      (inputtedNumber) => inputtedNumber[0] === i,
    );

    let updatedInput;
    if (indexOfNumber !== -1) {
      updatedInput = [...input];
      updatedInput[indexOfNumber] = [i, value];
    } else {
      updatedInput = [...input, [i, value]];
    }

    updatedInput.sort();
    const extractedValues = updatedInput.map((num) => num[1]);

    setInput(updatedInput);
    setInputI(extractedValues);

    console.log(updatedInput);
    console.log(extractedValues);

    if (extractedValues.length >= 1) {
      setGeneralError("");
    }
  };

  return {
    input,
    inp,
    generalError,
    setGeneralError,
    handleInput,
  };
}
