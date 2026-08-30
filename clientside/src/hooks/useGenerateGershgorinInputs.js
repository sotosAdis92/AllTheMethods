export default function useGenerateInputsGershgorin(matrix, entries) {
  for (let i = 0; i < 2 * matrix.length(); i++) {
    entries.push({
      id: i,
    });
  }
}
