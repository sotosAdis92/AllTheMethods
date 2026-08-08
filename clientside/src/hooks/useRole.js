import { useEffect, useState } from "react";
import { getUser } from "../services/UsersService";
export const ROLES = {};
export default function useRole() {
  const [role, setRole] = useState("");
  useEffect(() => {
    getUser().then((response) => {
      console.log(response.data);
      setRole(response.data.userRole);
    });
  }, []);
  return { role };
}
