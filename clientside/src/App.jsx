import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import MainAboutPage from "./Components/AboutPage/MainAboutPage";
import ListAchievements from "./Components/AchievementScreen/ListAchievements";
import AchievementComponent from "./Components/AdminPages/AchievementComponent";
import AdminHome from "./Components/AdminPages/AdminHome";
import ProblemComponent from "./Components/AdminPages/ProblemComponent";
import SubmissionComponent from "./Components/AdminPages/SubmissionsComponent";
import UsersComponent from "./Components/AdminPages/UsersComponent";
import Footer from "./Components/Footer";
import Header from "./Components/Header";
import ListProblems from "./Components/ListProblems";
import Login from "./Components/LoginSignUp/Login";
import Signup from "./Components/LoginSignUp/Signup";
import ProblemDescription from "./Components/ProblemScreen/ProblemDescription";
import MyProfile from "./Components/UserComponents/MyProfile";
import ProtectedRoute from "./context/ProtectedRoute";
function App() {
  return (
    <>
      <div className="App">
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
              path="/problems/admin/add"
              element={
                <ProtectedRoute roles={["ADMIN"]}>
                  <ProblemComponent></ProblemComponent>
                </ProtectedRoute>
              }
            ></Route>
            <Route
              path="/problems/admin/edit/:id"
              element={
                <ProtectedRoute roles={["ADMIN"]}>
                  <ProblemComponent></ProblemComponent>
                </ProtectedRoute>
              }
            ></Route>
            <Route
              path="/achievements"
              element={<ListAchievements></ListAchievements>}
            ></Route>
            <Route
              path="/achievements/admin/add"
              element={
                <ProtectedRoute roles={["ADMIN"]}>
                  <AchievementComponent></AchievementComponent>
                </ProtectedRoute>
              }
            ></Route>
            <Route
              path="/achievements/admin/update/:id"
              element={
                <ProtectedRoute roles={["ADMIN"]}>
                  <AchievementComponent></AchievementComponent>
                </ProtectedRoute>
              }
            ></Route>
            <Route path="/profile" element={<MyProfile></MyProfile>}></Route>
            <Route
              path="/about"
              element={<MainAboutPage></MainAboutPage>}
            ></Route>
            <Route
              path="problems/:id"
              element={<ProblemDescription></ProblemDescription>}
            ></Route>
            <Route path="/admin" element={<AdminHome></AdminHome>}></Route>
            <Route
              path="/admin/submissions"
              element={<SubmissionComponent></SubmissionComponent>}
            ></Route>
            <Route
              path="/admin/users"
              element={<UsersComponent></UsersComponent>}
            ></Route>
          </Routes>
        </BrowserRouter>
        <Footer></Footer>
      </div>
    </>
  );
}

export default App;
