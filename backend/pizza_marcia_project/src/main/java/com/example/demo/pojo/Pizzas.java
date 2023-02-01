package com.example.demo.pojo;

import javax.persistence.*;

@Entity
public class Pizzas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private Integer price;

    private Integer ingredients_id;

    public Pizzas(String name, Integer price, Integer ingredients_id) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getIngredients_id() {
        return ingredients_id;
    }

    public void setIngredients_id(Integer ingredients_id) {
        this.ingredients_id = ingredients_id;
    }
}
