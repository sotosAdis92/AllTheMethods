export default function useGenerateInputsDE(iterations, entries) {
  //Implement input generation based on how many iterations you have
  for (let i = 0; i < iterations; i++) {
    entries.push({
      id: i,
      placeholder: `y${i + 1}`,
      type: "number",
      label: `y_${i + 1} = `,
      name: "",
      i: { i },
      required: true,
    });
  }
}
