import {
  FormControl,
  FormGroup,
  InputLabel,
  MenuItem,
  OutlinedInput,
  Select,
  TextField,
} from "@mui/material";
import { string, array, object } from "prop-types";
import React, { useState } from "react";
import SubmitButtons from "./components/SubmitButtons/SubmitButtons";
import "./PizzaEditForm.css";

function getValueOrDefault(data) {
  return {
    id: data.id ?? "",
    name: data.name ?? "",
    price: data.price ?? "",
    image: data.image ?? "",
    ingredients: data.ingredients ?? [],
  };
}

function PizzaEditForm({ pizzaData, ingredients, mode }) {
  const [data, setData] = useState(getValueOrDefault(pizzaData));
  const [ingredientsIds, setIngredientsIds] = useState(
    data.ingredients.map((ingredient) => ingredient.id)
  );

  function setField(name) {
    return (value) => {
      setData((oldData) => ({
        ...oldData,
        [name]: value.target.value,
      }));
    };
  }

  return (
    <FormGroup className="pizza-edit-form-container">
      <FormControl className="pizza-edit-form-input" sx={{ m: 1 }}>
        <TextField
          fullWidth
          label="Name"
          required
          id="pizza-name"
          type="text"
          variant="outlined"
          value={data.name}
          onChange={setField("name")}
        />
      </FormControl>
      <FormControl className="pizza-edit-form-input" sx={{ m: 1 }}>
        <TextField
          fullWidth
          label="Price"
          required
          id="pizza-price"
          type="number"
          variant="outlined"
          value={data.price}
          onChange={setField("price")}
          InputProps={{
            inputProps: {
              min: 0,
            },
          }}
        />
      </FormControl>
      <FormControl className="pizza-edit-form-input" sx={{ m: 1 }}>
        <TextField
          fullWidth
          label="Image URL"
          required
          id="pizza-image"
          type="text"
          variant="outlined"
          value={data.image}
          onChange={setField("image")}
        />
      </FormControl>
      <FormControl className="pizza-edit-form-input" sx={{ m: 1 }}>
        <InputLabel id="pizza-ingredients-label">Ingredients</InputLabel>
        <Select
          fullWidth
          labelId="pizza-ingredients-label"
          id="pizza-ingredients"
          multiple
          value={ingredientsIds}
          onChange={(event) => setIngredientsIds(event.target.value)}
          input={<OutlinedInput label="Ingredients" />}
          MenuProps={{
            PaperProps: {
              style: {
                maxHeight: 48 * 4.5 + 8,
                width: 250,
              },
            },
          }}
        >
          {ingredients.map((ingredient) => (
            <MenuItem key={ingredient.id} value={ingredient.id}>
              {ingredient.name}
            </MenuItem>
          ))}
        </Select>
      </FormControl>
      <FormControl className="pizza-edit-form-input" sx={{ m: 1 }}>
        <SubmitButtons
          mode={mode}
          data={{ ...data, ingredients: ingredientsIds }}
        />
      </FormControl>
    </FormGroup>
  );
}

PizzaEditForm.defaultProps = {
  ingredients: [],
  pizzaData: {},
  mode: "",
};

PizzaEditForm.propTypes = {
  ingredients: array,
  pizzaData: object,
  mode: string,
};

export default PizzaEditForm;
