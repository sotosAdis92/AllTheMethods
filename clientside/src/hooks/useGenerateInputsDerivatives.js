export default function useGenerateInputDerivatives(entries) {
  for (let i = 0; i < 1; i++) {
    entries.push({
      id: i,
      placeholder: `f`,
      type: "text",
      label: `f = `,
      name: "",
      errorMessage:
        "Input should not be empty or other than a floating point/double number",
      i: { i },
      required: true,
      pattern: /^[+-]?\d+(\.\d+)?$/,
    });
  }
}
