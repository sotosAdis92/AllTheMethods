export default function useGenerateInputsBisection(iterations, entries) {
  for (let i = 0; i < iterations; i++) {
    entries.push({
      id: i,
      placeholder: `x${i}`,
      type: "number",
      label: `x_{${i}} = `,
      name: "",
      i: { i },
      required: true,
    });
  }
  return { entries };
}
