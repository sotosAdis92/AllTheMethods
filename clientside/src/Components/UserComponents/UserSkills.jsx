import { useEffect, useState } from "react";
import "../../App.css";
import { getCountDistinctProblemsByCategory } from "../../services/UserProblemService";
const UserSkills = (props) => {
  const [countCategories, setCountCategories] = useState([]);
  const userId = props.userId;
  console.log(userId);
  const getCountDistinctCategories = () => {
    getCountDistinctProblemsByCategory(userId)
      .then((response) => {
        console.log("User Skills response: ", response.data);
        setCountCategories(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    if (userId) {
      getCountDistinctCategories();
    }
  }, [userId]);

  const listOfSkills = countCategories.map((item, i) => {
    return (
      <div key={i}>
        <div>
          <div>{item[0]}</div> <div>x{item[1]}</div>
        </div>
      </div>
    );
  });

  return (
    <div className="userSkills">
      <div className="userSkillsHeading">Skills</div>
      <div className="userSkillsDiv">{listOfSkills}</div>
    </div>
  );
};
export default UserSkills;
