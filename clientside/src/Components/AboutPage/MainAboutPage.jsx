import Footer from "../Footer";
import AboutButtons from "./AboutButtons";
import AboutDescription from "./AboutDescription";
import AboutTitle from "./AboutTitle";
const MainAboutPage = () => {
  return (
    <>
      <div>
        <AboutTitle></AboutTitle>
        <AboutDescription></AboutDescription>
        <AboutButtons></AboutButtons>
        <Footer></Footer>
      </div>
    </>
  );
};
export default MainAboutPage;
