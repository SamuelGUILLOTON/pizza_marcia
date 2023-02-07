import React from "react";
import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import PizzaCreate from "./components/PizzaForm/PizzaCreate/PizzaCreate";
import PizzaEdit from "./components/PizzaForm/PizzaEdit/PizzaEdit";

export default createBrowserRouter([
  {
    path: "/",
    element: <App />,
    errorElement: (
      <p>
        404 not found <a href="/">home</a>
      </p>
    ),
    children: [
      {
        path: "/pizzas/create",
        element: <PizzaCreate />,
      },
      {
        path: "/pizzas/edit/:id",
        element: <PizzaEdit />,
      },
    ],
  },
]);
