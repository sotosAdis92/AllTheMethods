export default function useGenerateInputDerivatives(entries) {
  for (let i = 0; i < 1; i++) {
    entries.push({
      id: i,
      placeholder: `f`,
      type: "number",
      label: `f = `,
      name: "",
      errorMessage:
        "Input should not be empty or other than a floating point/double number",
      i: { i },
      required: true,
      pattern: "^([0-9]{1,}.[0-9])|([0-9],[0-9])$",
    });
  }
}
