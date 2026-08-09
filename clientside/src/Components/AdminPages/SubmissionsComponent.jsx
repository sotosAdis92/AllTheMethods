import { useEffect, useState } from "react";
import { getAllSubmissions } from "../../services/SubmitService";
const SubmissionComponent = () => {
  const [submissions, setSubmissions] = useState([]);
  const [pageNo, setPageNo] = useState(0);
  const [pageSize, setPageSize] = useState(30);
  const [totalPages, setTotalPages] = useState(0);
  const [count, setCount] = useState(0);
  const pageNumbers = [];

  useEffect(() => {
    getAllSubmissions().then((response) => {
      console.log(response.data.content);
      setSubmissions(response.data.content);
    });
  }, []);

  const listOfSubmissions = submissions.map((submission) => (
    <div key={submission.id}>
      <div>{submission.id}</div>
      <div>{submission.date}</div>
      <div>{submission.number}</div>
      <div>{submission.difficulty}</div>
      <div>{submission.title}</div>
    </div>
  ));

  return (
    <div>
      <div>{listOfSubmissions}</div>
    </div>
  );
};
export default SubmissionComponent;
