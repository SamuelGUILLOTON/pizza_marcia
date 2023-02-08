package com.marcia.pizza.service.implement;

import com.marcia.pizza.pojo.Ingredients;
import com.marcia.pizza.repository.IngredientRepository;
import com.marcia.pizza.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public List<Ingredients> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredients getIngredientById(Long id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    @Override
    public void createIngredient(Ingredients ingredient) {
        ingredientRepository.save(ingredient);
    }

    @Override
    public void updateIngredient(Ingredients ingredient, Long id) {
        Ingredients updatedIngredient = this.getIngredientById(id);
        updatedIngredient.setName(ingredient.getName());
        ingredientRepository.save(updatedIngredient);
    }

    @Override
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }
}
