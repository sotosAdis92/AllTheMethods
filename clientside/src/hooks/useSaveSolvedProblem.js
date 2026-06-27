import { saveSolvedProblem } from "../services/UserProblemService";
export default function useSaveSolvedProblem() {
  const decideToSaveSolvedProblem = async (
    result,
    savedProblem,
    setButtonDisabled,
  ) => {
    if (result === true) {
      await saveSolvedProblem(savedProblem).then((response) => {
        console.log(response.data);
      });
      setButtonDisabled(true);
    }
  };

  return { decideToSaveSolvedProblem };
}
