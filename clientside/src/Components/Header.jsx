import "./Header.css";
const Header = () => {
  return (
    <div className="container">
      <h3 className="title">All The Methods</h3>
      <ul className="links">
        <li className="link">
          <a href="/">Announcements</a>
        </li>
        <li className="link">
          <a href="/">Problems</a>
        </li>
        <li className="link">
          <a href="/">Profile</a>
        </li>
        <li className="link">
          <a href="/">Achievements</a>
        </li>
      </ul>
    </div>
  );
};
export default Header;
