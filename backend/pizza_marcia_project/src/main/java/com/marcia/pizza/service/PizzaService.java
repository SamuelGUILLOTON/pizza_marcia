package com.marcia.pizza.service;

import com.marcia.pizza.pojo.ApiResponse;
import com.marcia.pizza.pojo.Pizzas;

import java.util.List;

public interface PizzaService {

    List<Pizzas> getAllPizzas();

    Pizzas getPizzaById(Long id);

    List<Pizzas> findPizzasByNameLike(String name);

    ApiResponse createPizza(Pizzas pizza);

    ApiResponse updatePizza(Pizzas pizza, Long id);

    ApiResponse deletePizza(Long id);
}
