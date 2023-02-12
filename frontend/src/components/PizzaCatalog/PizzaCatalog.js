import { Button, CircularProgress } from "@mui/material";
import { array } from "prop-types";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import PizzaCard from "../PizzaCard/PizzaCard";
import "./PizzaCatalog.css";

function PizzaCards({ pizzas }) {
  const navigate = useNavigate();

  return pizzas.length !== 0 ? (
    <div className="pizza-cards-container">
      {pizzas.map((pizza) => (
        <PizzaCard
          key={pizza.id}
          className="pizza-card"
          id={pizza.id}
          name={pizza.name}
          price={pizza.price}
          image={pizza.image}
          ingredients={pizza.ingredients}
        />
      ))}
    </div>
  ) : (
    <div className="empty-catalog-container">
      <h1>There is currenctly 0 pizza in the catalog.</h1>
      <Button variant="contained" onClick={() => navigate("/pizzas/create")}>
        Create one
      </Button>
    </div>
  );
}

function PizzaCatalog() {
  const [data, setData] = useState({ pizzas: [], loading: true });

  useEffect(() => {
    async function getData() {
      try {
        const pizzas = await (await fetch("/api/pizza")).json();
        setData({ pizzas, loading: false });
      } catch (err) {
        throw new Error("API Error");
      }
    }
    if (data.loading) {
      getData();
    }
  }, []);

  return data.loading ? (
    <div className="loading-circle-container">
      <CircularProgress className="loading-circle" />
    </div>
  ) : (
    <PizzaCards pizzas={data.pizzas} />
  );
}

PizzaCards.defaultProps = {
  pizzas: [],
};

PizzaCards.propTypes = {
  pizzas: array,
};

export default PizzaCatalog;
