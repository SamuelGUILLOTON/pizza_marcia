import React from "react";
import { Button } from "@mui/material";
import { useNavigate } from "react-router-dom";
import "./Homepage.css";

function Homepage() {
  const navigate = useNavigate();

  return (
    <>
      <div className="homepage-container">
        <h1>The best pizza catalog in the world.</h1>
        <Button variant="contained" onClick={() => navigate("/pizzas")}>
          Catalog
        </Button>
      </div>
      <section>
        <img src="/pizzamanquote.jpg" alt="pizzaman" className="pizzaman" />
      </section>
    </>
  );
}

export default Homepage;
