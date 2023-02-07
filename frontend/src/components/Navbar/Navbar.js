import React from "react";
import { Link } from "react-router-dom";
import "./Navbar.css";

function Navbar() {
  return (
    <div className="navbar-container">
      <h1 className="navbar-title">Pizza Marcia</h1>
      <ul className="navbar-item-list">
        <li className="navbar-item">
          <Link className="navbar-link" to="/catalog">
            Catalog
          </Link>
        </li>
        <li className="navbar-item">
          <Link className="navbar-link" to="/pizzas/add">
            Add a Pizza
          </Link>
        </li>
        <li className="navbar-item">
          <Link className="navbar-link" to="/ingredients">
            Ingredients
          </Link>
        </li>
      </ul>
    </div>
  );
}

export default Navbar;
