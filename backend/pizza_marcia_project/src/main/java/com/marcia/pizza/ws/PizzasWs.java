package com.marcia.pizza.ws;

import com.marcia.pizza.pojo.ApiResponse;
import com.marcia.pizza.pojo.Pizzas;
import com.marcia.pizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiRegistration.API_WS)
public class PizzasWs {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/pizza")
    public List<Pizzas> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }

    @GetMapping("/pizza/{id}")
    public Pizzas getPizzaById(@PathVariable("id") Long id){

        return pizzaService.getPizzaById(id);
    }

    @GetMapping("/pizza/search/{name}")
    public List<Pizzas> getPizzaByNameContains(@PathVariable("name") String name) {
        return pizzaService.findPizzasByNameLike(name);
    }

    @PostMapping("/pizza")
    public ApiResponse createPizza(@RequestBody Pizzas pizza){
        return pizzaService.createPizza(pizza);
    }

    @PutMapping("/pizza/{id}")
    public ApiResponse updatePizza(@RequestBody Pizzas pizza,
                                   @PathVariable("id") Long id){
       return pizzaService.updatePizza(pizza,id);
    }

    @DeleteMapping("/pizza/{id}")
    public ApiResponse deleteCatalogue(@PathVariable("id") Long id){
            return pizzaService.deletePizza(id);
    }
}
