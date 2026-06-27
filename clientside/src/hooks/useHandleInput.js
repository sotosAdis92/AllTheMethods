import { useState } from "react";

export default function useHandleInput() {
  const [input, setInput] = useState([]);
  const [inp, setInputI] = useState([]);
  const [generalError, setGeneralError] = useState("");

  return { input, inp, generalError, setGeneralError, updateInput };
}
