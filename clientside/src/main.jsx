import { SnackbarProvider } from "notistack";
import { createRoot } from "react-dom/client";
import App from "./App.jsx";

createRoot(document.getElementById("root")).render(
  //<StrictMode>
  <SnackbarProvider maxSnack={3}>
    <App />
  </SnackbarProvider>,
  //</StrictMode>,
);
