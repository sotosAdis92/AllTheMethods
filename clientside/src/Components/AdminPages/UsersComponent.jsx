import { faTrashCan } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { useEffect, useState } from "react";
import arrowback from "../../assets/arrowback_2_10.png";
import arrowfront from "../../assets/arrowfront_10.png";
import { deleteUserById, getAllUsers } from "../../services/UsersService";
import "./UsersComponent.css";
const UsersComponent = () => {
  const [users, setUsers] = useState([]);
  const [count, setCount] = useState(0);
  const [pageNumber, setPageNumber] = useState(1);
  const [pageSize, setPageSize] = useState(30);
  const [sortBy, setSortBy] = useState("");
  const [sortDir, setSortDir] = useState("DESC");
  const [totalPages, setTotalPages] = useState(0);
  const pageNumbers = [];

  useEffect(() => {
    getAllUsers().then((response) => {
      console.log(response.data.content);
      setUsers(response.data.content);
      setCount(response.data.numberOfElements);
      setTotalPages(response.data.totalPages);
    });
  }, []);

  const deleteUser = (userId) => {
    deleteUserById(userId);
  };

  for (let i = 1; i <= totalPages; i++) {
    pageNumbers.push(i);
  }

  const pageNumberButtons = pageNumbers.map((number) => (
    <button
      key={number}
      onClick={() => setPageNumber(number)}
      className={`buttonNumberPage ${pageNumber === number ? "active" : ""}`}
    >
      {number}
    </button>
  ));

  const listOfUsers = users.map((user) => (
    <div className="user-item-table" key={user.id}>
      <div>{user.id}</div>
      <div>{user.username}</div>
      <div>{user.displayName}</div>
      <div>{user.userRole.toLowerCase()}</div>
      <button className="delete-btn-table" onClick={() => deleteUser(user.id)}>
        <FontAwesomeIcon icon={faTrashCan} />
      </button>
    </div>
  ));

  return (
    <div>
      <div>
        <div className="headerUser user-item-table">
          <div>Id</div>
          <div>Username</div>
          <div>Display Name</div>
          <div>Role</div>
        </div>
        {listOfUsers}
      </div>
      {totalPages > 1 ? (
        <div className="pageButtonsContainer">
          <button
            className="pageButton"
            onClick={() => setPageNumber((page) => Math.max(page - 1, 0))}
            disabled={pageNumber === 1}
          >
            <img src={arrowback} alt={arrowback}></img>
          </button>
          {pageNumberButtons}
          <button
            className="pageButton"
            onClick={() => setPageNumber((page) => Math.max(page, totalPages))}
            disabled={pageNumber === totalPages}
          >
            <img src={arrowfront} alt={arrowfront}></img>
          </button>
        </div>
      ) : (
        <div></div>
      )}
    </div>
  );
};
export default UsersComponent;
