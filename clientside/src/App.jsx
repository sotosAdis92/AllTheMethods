import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import Header from "./Components/Header";
import ListProblems from "./Components/ListProblems";
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
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
