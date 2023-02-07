import React, { useEffect, useState } from "react";
import PizzaEditForm from "../PizzaEditForm/PizzaEditForm";
import ingredientsJSON from "../../../db/ingredients.json";

function PizzaCreate() {
  const [data, setData] = useState({ ingredients: [], loading: true });

  useEffect(() => {
    // @TODO: Fetch DB data for ingredients
    setData((oldData) => ({ ...oldData, loading: false }));
  }, []);

  return (
    !data.loading && (
      <>
        <h1 style={{ textAlign: "center", marginTop: "2em" }}>
          Create a pizza
        </h1>
        <PizzaEditForm
          ingredients={ingredientsJSON.ingredients}
          mode="create"
        />
      </>
    )
  );
}

export default PizzaCreate;
