import { useParams } from "react-router-dom";
const GershgorinCirclesComponent = () => {
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

  const { achievements } = useFetchRelatedAchievements(props);
  const { userId } = useFetchUserId();
  useFetchIsSolved(props.isSolved, setButtonDisabled);
  const { input, inp, generalError, setGeneralError, handleInput } =
    useHandleInput();
  const { saveAchievementOfUser } = useSaveAchievementOfUser();
};
export default GershgorinCirclesComponent;
