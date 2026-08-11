import UnauthorizedAccess from "../Components/AdminPages/UnauthorizedAccess";
import useRole from "../hooks/useRole";
const ProtectedRoute = ({ children, roles }) => {
  const { role } = useRole();
  if (!roles.includes(role)) {
    return <UnauthorizedAccess></UnauthorizedAccess>;
  } else {
    return children;
  }
};
export default ProtectedRoute;
