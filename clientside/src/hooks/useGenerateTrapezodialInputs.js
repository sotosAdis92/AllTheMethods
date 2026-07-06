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
        pattern: "^([0-9]{1,}.[0-9])|([0-9],[0-9])$",
      });
    } else {
      if (i != integrationPointA && i != integrationPointB) {
        entries.push({
          id: i,
          placeholder: `2f(${i})`,
          type: "number",
          label: `2f(${i}) = `,
          errorMessage:
            "Input should not be empty or other than a floating point/double number",
          name: "",
          i: { i },
          required: true,
          pattern: "^([0-9]{1,}.[0-9])|([0-9],[0-9])$",
        });
      } else {
        entries.push({
          id: i,
          placeholder: `f(${i})`,
          type: "number",
          label: `f(${i}) = `,
          errorMessage:
            "Input should not be empty or other than a floating point/double number",
          name: "",
          i: { i },
          required: true,
          pattern: "^([0-9]{1,}.[0-9])|([0-9],[0-9])$",
        });
      }
    }
  }
  return { entries };
}
