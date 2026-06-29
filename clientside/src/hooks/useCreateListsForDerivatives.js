export default function useCreateListsForDerivatives(
  xiParameters,
  fiParameters,
  countingParameters,
) {
  const listOfXiParameters = xiParameters.map((parameter, i) => (
    <div key={i} className="xiParameters">
      {parameter}
    </div>
  ));

  const listOfFiParameters = fiParameters.map((parameter, i) => (
    <div key={i} className="fiParameters">
      {parameter}
    </div>
  ));

  const listOfCountingParameters = countingParameters.map((parameter, i) => (
    <div key={i} className="countingParameters">
      {parameter}
    </div>
  ));
  return { listOfXiParameters, listOfFiParameters, listOfCountingParameters };
}
