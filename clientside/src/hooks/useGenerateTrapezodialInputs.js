export default function useGenerateTrapezodialInputs(
  entries,
  integrationPointA,
  integrationPointB,
) {
  //Implement input generation based on how many iterations you have
  for (let i = integrationPointA; i <= integrationPointB + 1; i++) {
    if (i === integrationPointB + 1) {
      entries.push({
        id: i,
        placeholder: `Final`,
        label: `S = `,
        errorMessage:
          "Input should not be empty or other than a floating point/double number",
        name: "",
        i: { i },
        required: true,
        pattern: /^[+-]?\d+(\.\d+)?$/,
      });
    } else {
      if (i != integrationPointA && i != integrationPointB) {
        entries.push({
          id: i,
          placeholder: `2f(${i})`,
          type: "text",
          label: `2f(${i}) = `,
          errorMessage:
            "Input should not be empty or other than a floating point/double number",
          name: "",
          i: { i },
          required: true,
          pattern: /^[+-]?\d+(\.\d+)?$/,
        });
      } else {
        entries.push({
          id: i,
          placeholder: `f(${i})`,
          type: "text",
          label: `f(${i}) = `,
          errorMessage:
            "Input should not be empty or other than a floating point/double number",
          name: "",
          i: { i },
          required: true,
          pattern: /^[+-]?\d+(\.\d+)?$/,
        });
      }
    }
  }
  return { entries };
}
