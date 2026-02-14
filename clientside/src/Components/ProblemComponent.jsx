import { useState } from "react";
const ProblemComponent = () => {
  const [number, setNumber] = useState(0);
  const [title, setTitle] = useState("");
  const [category, setCategory] = useState("");
  const [difficulty, setDifficulty] = useState("");
  const [description, setDescription] = useState("");
  const [points, setPoints] = useState(0);

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
  const getSelectedDifficulty = (e) => {
    setDifficulty(e.target.value);
  };
  const increasePoints = () => {
    setPoints(points + 5);
  };
  const decreasePoints = () => {
    setPoints(points - 5);
  };
  const handleDescription = (e) => {
    setDescription(e.target.value);
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
      <div className="selector">
        <select onChange={getSelectedDifficulty} value={difficulty}>
          <option>Easy</option>
          <option>Med.</option>
          <option>Hard</option>
        </select>
      </div>
      <div className="row">
        <button className="changeNumber" onClick={increasePoints}></button>
        <button className="changeNumber" onClick={decreasePoints}></button>
        <p className="numberText">{points}</p>
      </div>
      <div className="row">
        <input
          type="text"
          placeholder="Enter Problem description"
          name="description"
          value={description}
          className="input"
          onChange={handleDescription}
        ></input>
      </div>
    </div>
  );
};
export default ProblemComponent;
