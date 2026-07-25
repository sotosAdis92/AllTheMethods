import { useEffect, useState } from "react";
import getCountDistinctProblemsByCategory from "../../services/UserProblemService";
const UserSkills = (props) => {
  const [countCategories, setCountCategories] = useState([]);
  const userId = props.userId;

  useEffect(() => {
    if (userId) {
      getCountDistinctProblemsByCategory(userId).then((response) => {
        console.log(response.data);
        setCountCategories(response.data);
      });
    }
  }, []);

  const listOfSkills = countCategories.map((item, i) => {
    <div key={i}>
      <div></div>
    </div>;
  });

  return (
    <div>
      <div>{listOfSkills}</div>
    </div>
  );
};
export default UserSkills;
