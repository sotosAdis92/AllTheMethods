import { useState } from "react";
const ProblemComponent = () => {
  const [number, setNumber] = useState(0);
  const [title, setTitle] = useState("");
  const [category, setCategory] = useState("");
  const [difficulty, setDifficulty] = useState("");
  const [description, setDescription] = useState("");
  const [point, setPoints] = useState(0);

  const increment = () => {
    setNumber(number + 1);
  };
  const decrement = () => {
    setNumber(number - 1);
  };
  const handleTitle = (e) => {
    setTitle(e.target.value);
  };
  const getSelectedCategory = (e) => {
    setCategory(e.target.value);
  };
  return (
    <div className="card">
      <div className="row">
        <button className="changeNumber" onClick={increment}></button>
        <button className="changeNumber" onClick={decrement}></button>
        <p className="numberText">{number}</p>
      </div>
      <div className="row">
        <input
          type="text"
          placeholder="Enter Problem title"
          name="title"
          value={title}
          className="input"
          onChange={handleTitle}
        ></input>
      </div>
      <div className="selector">
        <select onChange={getSelectedCategory} value={category}>
          <option>Polynomial Roots</option>
          <option>Integrals</option>
          <option>Derivatives</option>
          <option>Linear Systems</option>
          <option>Paremboles</option>
          <option>Differential Equations</option>
        </select>
      </div>
    </div>
  );
};
export default ProblemComponent;
