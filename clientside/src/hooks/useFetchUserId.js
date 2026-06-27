import { useEffect, useState } from "react";
import { getUser } from "../services/UsersService";

export default function useFetchUserId() {
  const [userId, setUsersId] = useState("");
  //Fetching the users id
  useEffect(() => {
    getUser().then((response) => {
      setUsersId(response.data.id);
    });
  }, []);

  return { userId };
}
