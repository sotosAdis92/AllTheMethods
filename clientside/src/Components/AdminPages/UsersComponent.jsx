import { faTrashCan } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { useEffect, useState } from "react";
import { deleteUserById, getAllUsers } from "../../services/UsersService";
import "./UsersComponent.css";
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
  }, []);

  const deleteUser = (userId) => {
    deleteUserById(userId);
  };

  const listOfUsers = users.map((user) => (
    <div className="user-item-table" key={user.id}>
      <div>Id: {user.id}</div>
      <div>Username: {user.username}</div>
      <div>Display Name: {user.displayName}</div>
      <div>Role: {user.userRole.toLowerCase()}</div>
      <button className="delete-btn-table" onClick={() => deleteUser(user.id)}>
        <FontAwesomeIcon icon={faTrashCan} />
      </button>
    </div>
  ));

  return (
    <div>
      <div>{listOfUsers}</div>
    </div>
  );
};
export default UsersComponent;
