import { Button } from "@mui/material";
import { object, string, func } from "prop-types";
import { useNavigate } from "react-router-dom";
import React from "react";

function handleRedirect(serverResponse, navigate) {
  if (serverResponse.success) {
    return navigate("/catalog");
  }
  return navigate("/server-error");
}

async function onCreate(data, navigate) {
  const ingredientsFormatted = data.ingredients.map((ingredient) => ({
    id: ingredient,
  }));
  const dataToSend = { ...data, ingredients: ingredientsFormatted };
  delete dataToSend.id;

  try {
    await fetch("/api/pizza", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(dataToSend),
    })
      .then((res) => res.json())
      .then((serverResponse) => handleRedirect(serverResponse, navigate));
  } catch (err) {
    throw new Error("API error");
  }
}

async function onEdit(data, navigate) {
  const ingredientsFormatted = data.ingredients.map((ingredient) => ({
    id: ingredient,
  }));
  const dataToSend = { ...data, ingredients: ingredientsFormatted };
  delete dataToSend.id;

  try {
    await fetch(`/api/pizza/${data.id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(dataToSend),
    })
      .then((res) => res.json())
      .then((serverResponse) => handleRedirect(serverResponse, navigate));
  } catch (err) {
    throw new Error("API error");
  }
}

function checkFields(data, setError) {
  if (data.name === "") {
    setError("name");
    return false;
  }
  if (data.price === "") {
    setError("price");
    return false;
  }
  if (data.image === "") {
    setError("image");
    return false;
  }
  return true;
}

function handleClick(data, mode, setError, navigate) {
  if (checkFields(data, setError)) {
    return mode === "edit" ? onEdit(data, navigate) : onCreate(data, navigate);
  }
  return null;
}

function SubmitButtons({ data, mode, setError }) {
  const navigate = useNavigate();

  return (
    <Button
      variant="contained"
      fullWidth
      style={{ fontWeight: 600 }}
      onClick={() => handleClick(data, mode, setError, navigate)}
    >
      {mode === "edit" ? "Edit" : "Save"}
    </Button>
  );
}

SubmitButtons.defaultProps = {
  data: {},
  mode: "",
  setError: () => {},
};

SubmitButtons.propTypes = {
  data: object,
  mode: string,
  setError: func,
};

export default SubmitButtons;
