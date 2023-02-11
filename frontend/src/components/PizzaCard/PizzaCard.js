import React from "react";
import {
  Card,
  CardActionArea,
  CardContent,
  CardMedia,
  Typography,
} from "@mui/material";
import { string, array, number } from "prop-types";

function PizzaCard({ name, price, image, ingredients }) {
  return (
    <Card sx={{ maxWidth: 345 }}>
      <CardActionArea>
        <CardMedia
          component="img"
          height="200"
          image={image}
          alt="Pizza Chèvre Miel"
          sx={{ width: 350, height: 200 }}
        />

        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {name}
          </Typography>
          <Typography gutterBottom variant="h5" component="div">
            {price.toString()}
          </Typography>
          <Typography gutterBottom variant="h5" component="div">
            {ingredients.map((ingredient) => ingredient.name)}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            Blablablablablabla
          </Typography>
        </CardContent>
      </CardActionArea>
    </Card>
  );
}

PizzaCard.defaultProps = {
  name: "Chèvre miel",
  price: 11.99,
  image:
    "https://lelocalapizzas.fr/wp-content/uploads/2022/02/recette-pizza-chevre-miel.jpg",
  ingredients: [
    { id: 1, name: "Miel", image: "" },
    { id: 2, name: "Fromage de chèvre", image: "" },
  ],
};

PizzaCard.propTypes = {
  name: string,
  price: number,
  image: string,
  ingredients: array,
};

export default PizzaCard;
