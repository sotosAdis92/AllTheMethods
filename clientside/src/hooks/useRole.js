import { useEffect } from "react";
import getUser from "../services/UsersService";
export default function useRole() {
  useEffect(() => {
    getUser().then((response) => {
      console.log(response.data);
    });
  });
}
