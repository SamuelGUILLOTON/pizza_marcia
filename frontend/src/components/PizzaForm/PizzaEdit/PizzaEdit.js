import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import PizzaEditForm from "../PizzaEditForm/PizzaEditForm";

function PizzaEdit() {
  const [data, setData] = useState({
    pizzaData: {},
    ingredients: [],
    loading: true,
  });
  const { id: pizzaId } = useParams();

  useEffect(() => {
    async function getData() {
      try {
        const pizzaData = await (await fetch(`/api/pizza/${pizzaId}`)).json();
        const ingredients = await (await fetch("/api/ingredient")).json();
        setData({ pizzaData, ingredients, loading: false });
      } catch (err) {
        setData({ pizzaData: { error: true } });
        throw new Error("API Error");
      }
    }
    if (data.loading) {
      getData();
    }
  }, []);

  if (data.pizzaData.error !== undefined) {
    return <h1 style={{ textAlign: "center" }}>Pizza not found</h1>;
  }
  return (
    !data.loading && (
      <>
        <h1 style={{ textAlign: "center", marginTop: "2em" }}>Edit a pizza</h1>
        <PizzaEditForm
          pizzaData={data.pizzaData}
          ingredients={data.ingredients}
          mode="edit"
        />
      </>
    )
  );
}

export default PizzaEdit;
