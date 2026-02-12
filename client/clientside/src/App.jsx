import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import Footer from "./components/Footer";
import Header from "./components/Header";
import ListProblemComponent from "./components/ListProblemsComponent";
function App() {
  return (
    <>
      <Header></Header>
      <BrowserRouter>
        <Routes>
          <Route
            path="/"
            element={<ListProblemComponent></ListProblemComponent>}
          ></Route>
        </Routes>
      </BrowserRouter>
      <Footer></Footer>
    </>
  );
}

export default App;
