package com.marcia.pizza.pojo;

import org.w3c.dom.Text;

import javax.persistence.*;

@Entity
@Table(name = "pizzas")
public class Pizzas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "image", nullable = true)
    private String image;

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

}
