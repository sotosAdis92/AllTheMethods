import { useEffect, useState } from "react";
import { getAllUsers } from "../../services/UsersService";
const UsersComponent = () => {
  const [users, setUsers] = useState([]);
  const [pageNo, setPageNo] = useState(0);
  const [pageSize, setPageSize] = useState(30);
  const [totalPages, setTotalPages] = useState(0);
  const [count, setCount] = useState(0);
  const pageNumbers = [];

  useEffect(() => {
    getAllUsers().then((response) => {
      console.log(response.data.content);
      setUsers(response.data.content);
    });
  });

  const listOfUsers = users.map((user) => (
    <div>
      <div>{user.id}</div>
    </div>
  ));

  return (
    <div>
      <div>{listOfUsers}</div>
    </div>
  );
};
export default UsersComponent;
