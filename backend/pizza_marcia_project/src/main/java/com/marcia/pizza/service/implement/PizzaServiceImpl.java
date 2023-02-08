package com.marcia.pizza.service.implement;

import com.marcia.pizza.pojo.Pizzas;
import com.marcia.pizza.repository.PizzaRepository;
import com.marcia.pizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public List<Pizzas> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    @Override
    public Pizzas getPizzaById(Long id) {
        return pizzaRepository.findById(id).orElse(null);
    }

    @Override
    public void createPizza(Pizzas pizza) {
        pizzaRepository.save(pizza);
    }

    @Override
    public void updatePizza(Pizzas pizza, Long id) {
        Pizzas updatedPizza = this.getPizzaById(id);
        updatedPizza.setName(pizza.getName());
        pizzaRepository.save(updatedPizza);
    }

    @Override
    public void deletePizza(Long id) {
        pizzaRepository.deleteById(id);
    }

}
