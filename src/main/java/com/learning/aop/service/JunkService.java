package com.learning.aop.service;

import com.learning.aop.enums.BurgerEnum;
import com.learning.aop.enums.PizzaEnum;
import com.learning.aop.model.Burger;
import com.learning.aop.model.FoodDto;
import com.learning.aop.model.Pizza;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JunkService {

    public List<Pizza> getTypesOfPizza()
    {
        return List.of(new Pizza(Map.of(PizzaEnum.HARISSA,10,PizzaEnum.PEPPERONI,20)),
                new Pizza(Map.of(PizzaEnum.PEPPERONI,20,PizzaEnum.HARISSA,20)));
    }
    public List<Burger> getTypesOfBurger()
    {
        return List.of(new Burger(BurgerEnum.CHEESE_BURGER),
                new Burger(BurgerEnum.VEG_BURGER),
                new Burger(BurgerEnum.NON_VEG_BURGER));
    }
    public int calcPrice(FoodDto food)
    {
        int cost = 0;
        List<Burger> burgerList = food.getBurgerList();
        List<Pizza> pizzaList = food.getPizzaList();
        for(Pizza pizza : pizzaList)
        {
            Map<PizzaEnum, Integer> pizzaOrder = pizza.getPizzaOrder();
            for(Map.Entry<PizzaEnum,Integer> entry : pizzaOrder.entrySet())
            {

                cost += entry.getValue()*entry.getKey().getCost();
            }
        }
        return cost;
    }
}
