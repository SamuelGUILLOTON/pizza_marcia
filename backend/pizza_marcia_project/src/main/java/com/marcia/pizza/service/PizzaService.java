package com.marcia.pizza.service;

import com.marcia.pizza.pojo.Pizzas;

import java.util.List;

public interface PizzaService {

    List<Pizzas> getAllPizzas();

    Pizzas getPizzaById(Long id);

    List<Pizzas> findPizzasByNameLike(String name);

    void createPizza(Pizzas pizza);

    void updatePizza(Pizzas pizza, Long id);

    void deletePizza(Long id);
}
