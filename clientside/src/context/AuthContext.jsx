import { createContext, useContext, useEffect, useState } from "react";
import { isTokenValid } from "../environment/common";
import { getUser } from "../services/UsersService";

const AuthContext = createContext();

export const useAuth = () => {
  const context = useContext(AuthContext);
  if (!context) {
    throw new Error("useAuth must be used within AuthProvider");
  }
  return context;
};

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const loadUser = async () => {
    const isLoggedIn = isTokenValid();
    setIsLoggedIn(isLoggedIn);

    if (isLoggedIn) {
      try {
        const response = await getUser();
        setUser(response.data);
      } catch (error) {
        console.log(error);
        setUser(null);
        setIsLoggedIn(false);
      }
    } else {
      setUser(null);
    }
  };

  useEffect(() => {
    loadUser();
  }, []);

  const logout = () => {
    setUser(null);
    setIsLoggedIn(false);
  };

  return (
    <AuthContext.Provider value={{ user, isLoggedIn, loadUser, logout }}>
      {children}
    </AuthContext.Provider>
  );
};
