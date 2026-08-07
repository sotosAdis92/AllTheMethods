import { useEffect } from "react";
import getUser from "../services/UsersService";
export const ROLES = {};
export default function useRole() {
  useEffect(() => {
    getUser().then((response) => {
      console.log(response.data);
    });
  });
}
