export default function useResultTextHook(result) {
  var text = "";
  if (result === false) {
    text = "Wrong Inputs For the Specific Problem, Problem Remains Unsolved";
  } else {
    text = "Correct Inputs for the Specific Problem!!!! Well Done!";
  }
  return { text };
}
