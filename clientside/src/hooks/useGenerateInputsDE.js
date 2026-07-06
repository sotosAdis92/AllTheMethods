export default function useGenerateInputsDE(iterations, entries) {
  //Implement input generation based on how many iterations you have
  for (let i = 0; i < iterations; i++) {
    entries.push({
      id: i,
      placeholder: `y${i + 1}`,
      type: "number",
      label: `y_${i + 1} = `,
      errorMessage:
        "Input should not be empty or other than a floating point/double number",
      name: "",
      i: { i },
      required: true,
      pattern: "^([0-9]{1,}.[0-9])|([0-9],[0-9])$",
    });
  }
}
