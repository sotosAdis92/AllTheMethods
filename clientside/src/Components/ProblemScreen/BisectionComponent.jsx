import { useState } from "react";
const BisectionComponent = (props) => {
  const [input, setInput] = useState([]);
  const [inp, setInp] = useState([]);
  var x = ``;
  var inputs = [];
  for (let i = 0; i < props.iterations; i++) {
    x = `x${i}`;
    inputs.push(
      <div key={i}>
        <span id={x}>{x}=</span>
        <input
          key={i}
          maxlength="5"
          placeholder={`X${i}`}
          name={`X${i}`}
          onChange={(e) => handleInputs(i, e)}
        ></input>
      </div>,
    );
  }

  function handleInputs(i, e) {
    const exists = input.findIndex((item) => item[0] === i);

    if (exists !== -1) {
      input[exists] = [i, Number(e.target.value)];
    } else {
      input.push([i, Number(e.target.value)]);
    }
    const inp = input.map((pair) => pair[1]);
    setInput([...input]);
    setInp(inp);
    console.log(input);
    console.log(inp);
  }

  return (
    <>
      <div></div>
    </>
  );
};

export default BisectionComponent;
