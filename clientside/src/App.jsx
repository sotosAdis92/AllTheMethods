import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import Header from "./Components/Header";
import ListProblems from "./Components/ListProblems";
import ProblemComponent from "./Components/ProblemComponent";
function App() {
  return (
    <>
      <BrowserRouter>
        <Header></Header>
        <Routes>
          <Route path="/" element={<ListProblems></ListProblems>}></Route>
          <Route
            path="/problems"
            element={<ListProblems></ListProblems>}
          ></Route>

          <Route
            path="/addProblem"
            element={<ProblemComponent></ProblemComponent>}
          ></Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
