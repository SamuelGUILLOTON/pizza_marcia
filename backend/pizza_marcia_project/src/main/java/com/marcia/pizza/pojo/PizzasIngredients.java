package com.marcia.pizza.pojo;

import javax.persistence.*;

@Entity
@Table(name = "pizzas_ingredients")
public class PizzasIngredients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizzas pizzas;

    @ManyToOne
    @JoinColumn(name = "ingredients_id")
    private Ingredients ingredients;

    @Column(name = "quantity", nullable = true)
    private Integer quantity;

    public Long getId() {

        return id;
    }

    public Pizzas getPizzas() {

        return pizzas;
    }

    public void setPizzas(Pizzas pizzas) {

        this.pizzas = pizzas;
    }

    public Ingredients getIngredients() {

        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {

        this.ingredients = ingredients;
    }

    public Integer getQuantity() {

        return quantity;
    }

    public void setQuantity(Integer quantity) {

        this.quantity = quantity;
    }

}
