export default function useGenerateInputDerivatives(entries) {
  for (let i = 0; i < 1; i++) {
    entries.push({
      id: i,
      placeholder: `f`,
      type: "number",
      label: `f = `,
      name: "",
      i: { i },
      required: true,
    });
  }
}
