import { useEffect, useState } from "react";
import "../../App.css";
import { getCountDistinctProblemsByCategory } from "../../services/UserProblemService";

const UserSkills = (props) => {
  const [countCategories, setCountCategories] = useState([]);
  const count = countCategories.filter((category) => category.id).length;
  const userId = props.userId;

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
      <div key={i} className="skillsItems">
        <div className="skillsItemName">{item[0]}</div>
        <div className="skillsItemCount">x{item[1]}</div>
      </div>
    );
  });

  return (
    <div className="userSkills">
      <div className="userSkillsHeading">Skills</div>
      {count > 0 ? (
        <div className="userSkillsDiv">{listOfSkills}</div>
      ) : (
        <div className="noSkillsYet">0 Skills Acquired</div>
      )}
    </div>
  );
};
export default UserSkills;
