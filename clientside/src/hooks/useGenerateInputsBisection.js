export default function useGenerateInputsBisection(iterations, entries) {
  for (let i = 0; i < iterations; i++) {
    entries.push({
      id: i,
      placeholder: `x${i}`,
      type: "number",
      label: `x_{${i}} = `,
      errorMessage:
        "Input Should not be empty or other than a floating point/double number",
      name: "",
      i: { i },
      required: true,
    });
  }
  return { entries };
}
