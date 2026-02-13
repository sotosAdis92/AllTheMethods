import "./Header.css";
const Header = () => {
  return (
    <div className="container">
      <h2 className="title">All The Methods</h2>
      <ul className="links">
        <li className="link">
          <a href="/">Announcements</a>
        </li>
        <li className="link">
          <a href="/">Problems</a>
        </li>
        <li className="link">
          <a href="/">Achievements</a>
        </li>
      </ul>
    </div>
  );
};
export default Header;
