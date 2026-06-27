export default function useGetTimeAndDate() {
  //Setting up the local time objects for the submission
  const d = new Date();
  let date = d.toLocaleDateString();
  let time = d.toLocaleTimeString();
  let submittedAt = date + " " + time;
  return { submittedAt };
}
