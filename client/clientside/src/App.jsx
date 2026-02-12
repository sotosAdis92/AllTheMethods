import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import ListProblemComponent from "./components/ListProblemsComponent";
function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route
            path="/"
            element={<ListProblemComponent></ListProblemComponent>}
          ></Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
