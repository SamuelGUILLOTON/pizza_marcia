package com.marcia.pizza.service.implement;

import com.marcia.pizza.pojo.Pizzas;
import com.marcia.pizza.pojo.ApiResponse;
import com.marcia.pizza.repository.PizzaRepository;
import com.marcia.pizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Pizzas> findPizzasByNameLike(String name) {
        List<Pizzas>  pizzaName = pizzaRepository.findByNameLike('%'+name+'%');
        if (pizzaName != null) {
            return pizzaName;
        } else {
            return new ArrayList<Pizzas>();
        }
    }

    @Override
    public ApiResponse createPizza(Pizzas pizza) {
        try {
            pizzaRepository.save(pizza);
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setId(pizza.getId());
            apiResponse.setSuccess(true);
            return apiResponse;
        } catch (  DataAccessException ex) {
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setMessage("erreur");
            apiResponse.setSuccess(false);
            return apiResponse;
        }
    }

    @Override
    public ApiResponse updatePizza(Pizzas pizza, Long id) {
        try {
            Pizzas updatedPizza = this.getPizzaById(id);
            updatedPizza.setName(pizza.getName());
            updatedPizza.setPrice(pizza.getPrice());
            updatedPizza.setImage(pizza.getImage());
            updatedPizza.setIngredients(pizza.getIngredients());
            pizzaRepository.save(updatedPizza);
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setId(id);
            apiResponse.setSuccess(true);
            return apiResponse;
        } catch ( DataAccessException ex) {
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setMessage("erreur");
            apiResponse.setSuccess(false);
            return apiResponse;
        }
    }
    @Override
    public ApiResponse deletePizza(Long id) {
        try {
            pizzaRepository.deleteById(id);
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setSuccess(true);
            return apiResponse;
        } catch ( DataAccessException ex) {
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setMessage("erreur");
            apiResponse.setSuccess(false);
            return apiResponse;
        }
    }

}
