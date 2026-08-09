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
    });
  });
};
export default SubmissionComponent;
