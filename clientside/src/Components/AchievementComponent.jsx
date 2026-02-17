import { useNavigate } from "react-router-dom";

const AchievementComponent = () => {
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [category, setCategory] = useState("");
  const [rank, setRank] = useState("");
  const [visibility, setVisibility] = useState("");
  const navigator = useNavigate;
  return (
    <div>
      <div className="card">
        <div className="row"></div>
      </div>
    </div>
  );
};
export default AchievementComponent;
