import React from "react";
import { Link } from "react-router-dom";
import "./Navbar.css";

function Navbar() {
  return (
    <div className="navbar-container">
      <Link to="/" className="navbar-title-link">
        <h1 className="navbar-title">Pizza Marcia</h1>
      </Link>
      <ul className="navbar-item-list">
        <li className="navbar-item">
          <Link className="navbar-link" to="/catalog">
            Catalog
          </Link>
        </li>
        <li className="navbar-item">
          <Link className="navbar-link" to="/pizzas/create">
            Add a Pizza
          </Link>
        </li>
      </ul>
    </div>
  );
}

export default Navbar;
