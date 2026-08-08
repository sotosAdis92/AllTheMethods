const AdminHome = () => {
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
            <li>{choice}</li>;
          })}
        </ul>
      </div>
    </div>
  );
};
export default AdminHome;
