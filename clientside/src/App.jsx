import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import AchievementComponent from "./Components/AchievementComponent";
import Dashboard from "./Components/Dashboard";
import Header from "./Components/Header";
import ListAchievements from "./Components/ListAchievements";
import ListProblems from "./Components/ListProblems";
import Login from "./Components/Login";
import ProblemComponent from "./Components/ProblemComponent";
import Signup from "./Components/Signup";
function App() {
  return (
    <>
      <BrowserRouter>
        <Header></Header>
        <Routes>
          <Route path="/dashboard" element={<Dashboard></Dashboard>}></Route>
          <Route path="/register" element={<Signup></Signup>}></Route>
          <Route path="/login" element={<Login></Login>}></Route>
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
