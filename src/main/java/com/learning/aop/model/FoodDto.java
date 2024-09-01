package com.learning.aop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class FoodDto {
    List<Pizza> pizzaList;
    List<Burger> burgerList;
}
