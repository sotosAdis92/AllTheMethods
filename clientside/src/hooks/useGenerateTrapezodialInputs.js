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
        name: "",
        i: { i },
        required: true,
      });
    } else {
      if (i != integrationPointA && i != integrationPointB) {
        entries.push({
          id: i,
          placeholder: `2f(${i})`,
          type: "number",
          label: `2f(${i}) = `,
          name: "",
          i: { i },
          required: true,
        });
      } else {
        entries.push({
          id: i,
          placeholder: `f(${i})`,
          type: "number",
          label: `f(${i}) = `,
          name: "",
          i: { i },
          required: true,
        });
      }
    }
  }
}
