package com.marcia.pizza.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ingredients")
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image", nullable = true)
    private String image;

    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.LAZY)
    private Set<Pizzas> pizzas;
    public Ingredients(String name) {

        this.name = name;
    }

    public Ingredients() {

    }

    public Long getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getImage() {

        return image;
    }

    public void setImage(String image) {

        this.image = image;
    }

    public Set<Pizzas> getPizzas() {
        return pizzas;
    }

    public void setPizzas(Set<Pizzas> pizzas) {
        this.pizzas = pizzas;
    }

}
