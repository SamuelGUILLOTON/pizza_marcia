package com.marcia.pizza.ws;

import com.marcia.pizza.pojo.Ingredients;
import com.marcia.pizza.pojo.Pizzas;
import com.marcia.pizza.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiRegistration.API_WS)
public class IngredientsWs {

    @Autowired
    private IngredientService ingredientsService;

    @GetMapping("/ingredient")
    public List<Ingredients> getAllIngredients() {
        return ingredientsService.getAllIngredients();
    }

    @GetMapping("/ingredient/{id}")
    public Ingredients getIngredientById(@PathVariable("id") Long id){

        return ingredientsService.getIngredientById(id);
    }

    @GetMapping("/ingredient/search/{name}")
    public List<Ingredients> getIngredientsByNameContains(@PathVariable("name") String name) {
        return ingredientsService.findIngredientByNameLike(name);
    }

    @PostMapping("/ingredient")
    public void createIngredient(@RequestBody Ingredients ingredient){

        ingredientsService.createIngredient(ingredient);
    }

    @PutMapping("/ingredient/{id}")
    public void updateIngredient(@RequestBody Ingredients ingredient,
                            @PathVariable("id") Long id){
        ingredientsService.updateIngredient(ingredient,id);

    }

    @DeleteMapping("/ingredient/{id}")
    public void ingredientCatalogue(@PathVariable("id") Long id){
          ingredientsService.deleteIngredient(id);
    }
}
