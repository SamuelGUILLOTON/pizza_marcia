package com.marcia.pizza.repository;

import com.marcia.pizza.pojo.Pizzas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  PizzaRepository extends JpaRepository<Pizzas,Long> {

    // SELECT * FROM Pizza WHERE name=name
    List<Pizzas> findByName(String name);
    List<Pizzas> findByNameLike(String name);
}
