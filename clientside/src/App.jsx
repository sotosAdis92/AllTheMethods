import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import AchievementComponent from "./Components/AchievementComponent";
import Header from "./Components/Header";
import ListAchievements from "./Components/ListAchievements";
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
          <Route
            path="/editProblem/:id"
            element={<ProblemComponent></ProblemComponent>}
          ></Route>
          <Route
            path="/achievements"
            element={<ListAchievements></ListAchievements>}
          ></Route>
          <Route
            path="/addAchievement"
            element={<AchievementComponent></AchievementComponent>}
          ></Route>
          <Route
            path="/updateAchievements/:id"
            element={<AchievementComponent></AchievementComponent>}
          ></Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
