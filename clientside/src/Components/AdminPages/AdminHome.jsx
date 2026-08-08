import { useState } from "react";

const AdminHome = () => {
  const [choice, setChoice] = useState("");
  const choices = {
    0: "Problems",
    1: "Achivements",
    2: "Users",
    3: "Submissions",
  };
  return (
    <div>
      <div>
        <ul>
          {choices.map((choice) => {
            <li onChange={() => setChoice(choice)}>{choice}</li>;
          })}
        </ul>
      </div>
      <div>{}</div>
    </div>
  );
};
export default AdminHome;
