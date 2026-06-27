import { useEffect } from "react";
export default function useFetchIsSolved(props, setButtonDisabled) {
  useEffect(() => {
    if (props.isSolved) {
      setButtonDisabled(true);
    }
  }, [props.isSolved, setButtonDisabled]);
  return {};
}
