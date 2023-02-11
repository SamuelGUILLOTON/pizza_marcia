import React, { useEffect, useState } from "react";
import PizzaEditForm from "../PizzaEditForm/PizzaEditForm";

function PizzaCreate() {
  const [data, setData] = useState({ ingredients: [], loading: true });

  useEffect(() => {
    async function getData() {
      try {
        const ingredients = await (await fetch("/api/ingredient")).json();
        setData({ ingredients, loading: false });
      } catch (err) {
        throw new Error("API Error");
      }
    }
    if (data.loading) {
      getData();
    }
  }, []);

  return (
    !data.loading && (
      <>
        <h1 style={{ textAlign: "center", marginTop: "2em" }}>
          Create a pizza
        </h1>
        <PizzaEditForm ingredients={data.ingredients} mode="create" />
      </>
    )
  );
}

export default PizzaCreate;
