import Footer from "../Footer";
import AboutButtons from "./AboutButtons";
import AboutDescription from "./AboutDescription";
import AboutTitle from "./AboutTitle";
import ExternalLink from "./ExternalLink";
const MainAboutPage = () => {
  return (
    <>
      <div>
        <AboutTitle></AboutTitle>
        <AboutDescription></AboutDescription>
        <AboutButtons></AboutButtons>
        <ExternalLink></ExternalLink>
        <Footer></Footer>
      </div>
    </>
  );
};
export default MainAboutPage;
