import React from "react";
import { Button, CardActions } from "@mui/material";
import { number } from "prop-types";
import "./PizzaCardActions.css";
import { useNavigate } from "react-router-dom";

function onEdit(pizzaId, navigate) {
  return navigate(`/pizzas/edit/${pizzaId}`);
}

function onDelete(pizzaId, navigate) {
  fetch(`/api/pizza/${pizzaId}`, { method: "DELETE" })
    .then((res) => res.json())
    .then((serverResponse) => {
      if (!serverResponse.success) {
        throw new Error("API Error");
      }
      navigate(0);
    })
    .catch(() => {
      throw new Error("API Error");
    });
}

function PizzaCardActions({ pizzaId }) {
  const navigate = useNavigate();

  return (
    <CardActions className="pizza-card-actions-container">
      <Button variant="contained" onClick={() => onEdit(pizzaId, navigate)}>
        Edit
      </Button>
      <Button variant="contained" onClick={() => onDelete(pizzaId, navigate)}>
        Delete
      </Button>
    </CardActions>
  );
}

PizzaCardActions.defaultProps = {
  pizzaId: null,
};

PizzaCardActions.propTypes = {
  pizzaId: number,
};

export default PizzaCardActions;
