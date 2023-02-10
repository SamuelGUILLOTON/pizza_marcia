package com.marcia.pizza.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pizzas")
public class Pizzas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "image", nullable = true)
    private String image;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "pizzas_ingredients",
        joinColumns = {
                @JoinColumn(name = "pizza_id", referencedColumnName = "id")
        },
        inverseJoinColumns = {
                @JoinColumn(name = "ingredients_id", referencedColumnName = "id")
        }
    )
    @JsonManagedReference
    private Set<Ingredients> ingredients;

    public Pizzas(String name, Integer price, Integer ingredients_id) {
        this.name = name;
        this.price = price;
    }

    public Pizzas() {

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

    public Integer getPrice() {

        return price;
    }

    public void setPrice(Integer price) {

        this.price = price;
    }

    public String getImage() {

        return image;
    }

    public void setImage(String image) {

        this.image = image;
    }

    public Set<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

}
