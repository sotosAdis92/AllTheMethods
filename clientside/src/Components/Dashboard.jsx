import { useEffect, useState } from "react";
import { getUser } from "../services/UsersService";
const Dashboard = () => {
  const [displayName, setDisplayName] = useState("");
  const getUserData = () => {
    getUser()
      .then((response) => {
        setDisplayName(response.data.displayName);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    getUserData();
  }, []);
  return (
    <>
      <h1>Dashboard</h1>
      <div>{displayName}</div>
    </>
  );
};

export default Dashboard;
