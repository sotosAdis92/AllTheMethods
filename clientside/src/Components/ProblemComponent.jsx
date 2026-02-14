import { useState } from "react";
const ProblemComponent = () => {
  const [number, setNumber] = useState("");
  const [title, setTitle] = useState("");
  const [category, setCategory] = useState("");
  const [difficulty, setDifficulty] = useState("");
  const [description, setDescription] = useState("");
  const [point, setPoints] = useState("");
  return (
    <div className="cardContainer">
      <div className="row">
        <div className="card">
          <h2 className=""></h2>
        </div>
      </div>
    </div>
  );
};
export default ProblemComponent;
