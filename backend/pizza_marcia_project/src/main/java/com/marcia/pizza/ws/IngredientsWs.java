package com.marcia.pizza.ws;

import com.marcia.pizza.pojo.Ingredients;
import com.marcia.pizza.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiRegistration.INGREDIENT_WS)
public class IngredientsWs {

    @Autowired
    private IngredientService ingredientsService;

    @GetMapping
    public List<Ingredients> getAllIngredients() {
        return ingredientsService.getAllIngredients();
    }

    @GetMapping("/{id}")
    public Ingredients getIngredientById(@PathVariable("id") Long id){

        return ingredientsService.getIngredientById(id);
    }

    @PostMapping(consumes={"application/json"})
    public void createIngredient(@RequestBody Ingredients ingredient){

        ingredientsService.createIngredient(ingredient);
    }

    @PutMapping("/{id}")
    public void updateIngredient(@RequestBody Ingredients ingredient,
                            @PathVariable("id") Long id){
        ingredientsService.updateIngredient(ingredient,id);

    }

    @DeleteMapping("/{id}")
    public void ingredientCatalogue(@PathVariable("id") Long id){
          ingredientsService.deleteIngredient(id);
    }
}
