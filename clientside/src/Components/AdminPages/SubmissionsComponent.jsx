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
      <div>Id:{submission.id}</div>
      <div>Date:{submission.date}</div>
      <div>Problem Title:{submission.title}</div>
      <div>Problem Number:{submission.number}</div>
      <div>Problem Difficulty:{submission.difficulty}</div>
    </div>
  ));

  return (
    <div>
      <div>{listOfSubmissions}</div>
    </div>
  );
};
export default SubmissionComponent;
