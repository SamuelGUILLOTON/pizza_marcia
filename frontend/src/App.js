import React from "react";
import { Outlet } from "react-router-dom";
import Navbar from "./components/Navbar/Navbar";
import Footer from "./components/Footer/Footer";
import PizzaCard from "./components/PizzaCard/PizzaCard";
import "./App.css";

function App() {
  return (
    <>
      <Navbar />
      <PizzaCard />
      <Outlet />
      <Footer />
    </>
  );
}

export default App;
