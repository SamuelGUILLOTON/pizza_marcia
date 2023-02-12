import React from "react";
import { Card, CardContent, CardMedia, Typography } from "@mui/material";
import { string, array, number } from "prop-types";
import PizzaCardActions from "./components/PizzaCardActions";

function PizzaCard({ className, id, name, price, image, ingredients }) {
  return (
    <Card sx={{ maxWidth: 345 }} className={className}>
      <CardMedia
        component="img"
        height="200"
        image={image}
        alt={name}
        sx={{ width: 350, height: 200 }}
      />

      <CardContent>
        <Typography variant="subtitle1" component="div">
          Name:
        </Typography>
        <span>{name}</span>
        <Typography variant="subtitle1" component="div">
          Price:
        </Typography>
        <span>{price.toString()} €</span>
        {ingredients.length !== 0 && (
          <>
            <Typography variant="subtitle1" component="div">
              Ingredients:{" "}
            </Typography>
            <span>
              {ingredients.map((ingredient) => `${ingredient.name}, `)}
            </span>
          </>
        )}
      </CardContent>
      <PizzaCardActions pizzaId={id} />
    </Card>
  );
}

PizzaCard.defaultProps = {
  id: null,
  className: "",
  name: "",
  price: 0,
  image: "",
  ingredients: [],
};

PizzaCard.propTypes = {
  id: number,
  className: string,
  name: string,
  price: number,
  image: string,
  ingredients: array,
};

export default PizzaCard;
