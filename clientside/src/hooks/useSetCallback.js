export default function useSetCallback(props) {
  const setCallback = (result) => {
    if (props.onResultReceived) {
      props.onResultReceived(result);
    }
  };
  return { setCallback };
}
