import {
  Button,
  FormControl,
  FormGroup,
  InputLabel,
  MenuItem,
  OutlinedInput,
  Select,
  TextField,
} from "@mui/material";
import { string, array } from "prop-types";
import React, { useState } from "react";
import "./PizzaEditForm.css";

function PizzaEditForm({ ingredients, mode }) {
  const [data, setData] = useState({
    name: "",
    price: "",
    image: "",
    ingredients: [],
  });

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
          value={data.ingredients}
          onChange={setField("ingredients")}
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
        <Button variant="contained" fullWidth style={{ fontWeight: 600 }}>
          {mode === "edit" ? "Edit" : "Save"}
        </Button>
      </FormControl>
    </FormGroup>
  );
}

PizzaEditForm.defaultProps = {
  ingredients: [],
  mode: "",
};

PizzaEditForm.propTypes = {
  ingredients: array,
  mode: string,
};

export default PizzaEditForm;
