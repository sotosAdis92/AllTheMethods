import { useState } from "react";
const ProblemComponent = () => {
  const [number, setNumber] = useState("");
  const [title, setTitle] = useState("");
  const [category, setCategory] = useState("");
  const [difficulty, setDifficulty] = useState("");
  const [description, setDescription] = useState("");
  const [point, setPoints] = useState("");
  return (
    <div className="card">
      <div className="row">
        <button></button>
        <button></button>
        <p></p>
      </div>
    </div>
  );
};
export default ProblemComponent;
