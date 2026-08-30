export default function useGenerateInputsGershgorin(matrix, entries) {
  const matrixSize = matrix.length();
  for (let i = 0; i < matrixSize; i++) {
    entries.push({
      iid: i * 2,
      placeholder: `min P${i + 1}`,
      type: "text",
      label: i === 0 ? "P1 = " : "",
      errorMessage: "Input should be a floating point/double number",
      name: `P${i + 1}_min`,
      required: true,
      pattern: /^[+-]?\d+(\.\d+)?$/,
      position: "left",
      index: i,
      pairId: i,
    });

    entries.push({
      id: i * 2 + 1,
      placeholder: `max P${i + 1}`,
      type: "text",
      label: ` < P${i + 1} < `,
      errorMessage: "Input should be a floating point/double number",
      name: `P${i + 1}_max`,
      required: true,
      pattern: /^[+-]?\d+(\.\d+)?$/,
      position: "right",
      index: i,
      pairId: i,
    });
  }
}
