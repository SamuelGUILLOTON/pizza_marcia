import { Button } from "@mui/material";
import { object, string } from "prop-types";
import React from "react";

async function onCreate(data) {
  try {
    await fetch("/api/pizza", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    });
  } catch (err) {
    throw new Error("API error");
  }
}

async function onEdit(data) {
  try {
    await fetch(`/api/pizza/${data.id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    });
  } catch (err) {
    throw new Error("API error");
  }
}

function handleClick(data, mode) {
  return mode === "edit" ? onEdit(data) : onCreate(data);
}

function SubmitButtons({ data, mode }) {
  return (
    <Button
      variant="contained"
      fullWidth
      style={{ fontWeight: 600 }}
      onClick={() => handleClick(data, mode)}
    >
      {mode === "edit" ? "Edit" : "Save"}
    </Button>
  );
}

SubmitButtons.defaultProps = {
  data: {},
  mode: "",
};

SubmitButtons.propTypes = {
  data: object,
  mode: string,
};

export default SubmitButtons;
