import useRole from "../hooks/useRole";

const ProtectedRoute = ({ children, roles }) => {
  const { role } = useRole();
  if (!roles.includes(role)) {
    return <div>Unauthorized</div>;
  } else {
    return children;
  }
};
export default ProtectedRoute;
