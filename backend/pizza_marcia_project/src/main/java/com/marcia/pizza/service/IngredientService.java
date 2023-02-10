package com.marcia.pizza.service;

import com.marcia.pizza.pojo.Ingredients;

import java.util.List;

public interface IngredientService {

    List<Ingredients> getAllIngredients();

    Ingredients getIngredientById(Long id);

    void createIngredient(Ingredients ingredient);

    void updateIngredient(Ingredients ingredient, Long id);

    void deleteIngredient(Long id);
}
