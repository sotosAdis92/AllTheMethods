import { useEffect, useState } from "react";
const BisectionComponent = () => {
  const [description, setDescription] = useState("");
  const [problemData, setProblemData] = useState("");
  const [problemString, setProblemString] = useState("");
  useEffect(() => {});
  return (
    <>
      <div>{description}</div>
      <div>{problemData}</div>
      <div>{problemString}</div>
    </>
  );
};

export default BisectionComponent;
