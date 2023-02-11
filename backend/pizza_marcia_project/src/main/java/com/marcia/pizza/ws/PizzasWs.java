package com.marcia.pizza.ws;

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

    @GetMapping("/pizzas")
    public List<Pizzas> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }

    @GetMapping("/pizza/{id}")
    public Pizzas getPizzaById(@PathVariable("id") Long id){

        return pizzaService.getPizzaById(id);
    }

    @GetMapping("/pizzas/search/{name}")
    public List<Pizzas> getPizzaByNameContains(@PathVariable("name") String name) {
        return pizzaService.findPizzasByNameLike(name);
    }

    @PostMapping("/pizza")
    public void createPizza(@RequestBody Pizzas pizza){

        pizzaService.createPizza(pizza);
    }

    @PutMapping("/pizza/{id}")
    public boolean updatePizza(@RequestBody Pizzas pizza,
                                @PathVariable("id") Long id){
        pizzaService.updatePizza(pizza,id);
        return true;
    }

    @DeleteMapping("/pizza/{id}")
    public boolean deleteCatalogue(@PathVariable("id") Long id){

        if (pizzaService.getPizzaById(id) != null) {
            pizzaService.deletePizza(id);
            return true;
        } else {
            return false;
        }


    }
}
