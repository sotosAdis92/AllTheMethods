import { useParams } from "react-router-dom";
import useFetchIsSolved from "../../hooks/useFetchIsSolved";
import useFetchLinearSystems from "../../hooks/useFetchLinearSystems";
import useFetchRelatedAchievements from "../../hooks/useFetchRelatedAchivements";
import useFetchUserId from "../../hooks/useFetchUserId";
import useHandleInput from "../../hooks/useHandleInput";
import useSaveAchievementOfUser from "../../hooks/useSaveAchievementOfUser";

const GershgorinCirclesComponent = (props) => {
  const { id } = useParams();
  const [result, setResult] = useState(false);
  const [resultText, setResultText] = useState("");
  const [isButtonDisabled, setButtonDisabled] = useState(false);
  const [errorBool, setErrorBool] = useState(false);

  let text;
  const [values, setValues] = useState({
    entry: "",
  });
  var entries = [];
  const { problemId, problemData, matrix } = useFetchLinearSystems;
  const { achievements } = useFetchRelatedAchievements(props);
  const { userId } = useFetchUserId();
  useFetchIsSolved(props.isSolved, setButtonDisabled);
  const { input, inp, generalError, setGeneralError, handleInput } =
    useHandleInput();
  const { saveAchievementOfUser } = useSaveAchievementOfUser();
};
export default GershgorinCirclesComponent;
