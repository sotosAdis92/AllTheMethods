import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import MainAboutPage from "./Components/AboutPage/MainAboutPage";
import AchievementComponent from "./Components/AchievementScreen/AchievementComponent";
import ListAchievements from "./Components/AchievementScreen/ListAchievements";
import Header from "./Components/Header";
import ListProblems from "./Components/ListProblems";
import Login from "./Components/Login";
import ProblemComponent from "./Components/ProblemComponent";
import ProblemDescription from "./Components/ProblemScreen/ProblemDescription";
import Signup from "./Components/Signup";
import MyProfile from "./Components/UserComponents/MyProfile";
import ViewMyAchievements from "./Components/UserComponents/ViewMyAchievements";
import ViewMyProblems from "./Components/UserComponents/ViewMyProblems";
function App() {
  return (
    <>
      <BrowserRouter>
        <Header></Header>
        <Routes>
          <Route path="/" element={<MainAboutPage></MainAboutPage>}></Route>
          <Route path="/register" element={<Signup></Signup>}></Route>
          <Route path="/login" element={<Login></Login>}></Route>
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
          <Route
            path="/viewUserAchievements"
            element={<ViewMyAchievements></ViewMyAchievements>}
          ></Route>
          <Route
            path="/viewUserProblems"
            element={<ViewMyProblems></ViewMyProblems>}
          ></Route>
          <Route path="/profile/" element={<MyProfile></MyProfile>}></Route>
          <Route
            path="/about"
            element={<MainAboutPage></MainAboutPage>}
          ></Route>
          <Route
            path="problems/:id"
            element={<ProblemDescription></ProblemDescription>}
          ></Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
