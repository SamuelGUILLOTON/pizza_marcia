package com.marcia.pizza.ws;

import com.marcia.pizza.pojo.Pizzas;
import com.marcia.pizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiRegistration.PIZZA_WS)
public class PizzasWs {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public List<Pizzas> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }

    @GetMapping("/{id}")
    public Pizzas getPizzaById(@PathVariable("id") Long id){

        return pizzaService.getPizzaById(id);
    }

    @PostMapping(consumes={"application/json"})
    public void createPizza(@RequestBody Pizzas pizza){

        pizzaService.createPizza(pizza);
    }

    @PutMapping("/{id}")
    public void updatePizza(@RequestBody Pizzas pizza,
                                @PathVariable("id") Long id){
        pizzaService.updatePizza(pizza,id);

    }

    @DeleteMapping("/{id}")
    public boolean deleteCatalogue(@PathVariable("id") Long id){

        if (pizzaService.getPizzaById(id) != null) {
            pizzaService.deletePizza(id);
            return true;
        } else {
            return false;
        }


    }
}
