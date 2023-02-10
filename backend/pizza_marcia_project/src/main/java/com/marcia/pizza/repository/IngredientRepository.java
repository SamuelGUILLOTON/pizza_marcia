package com.marcia.pizza.repository;

import com.marcia.pizza.pojo.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredients,Long> {

    // SELECT * FROM Ingredients WHERE name=name
    List<Ingredients> findByNameLike(String name);
}
