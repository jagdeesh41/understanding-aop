package com.learning.aop.model;

import com.learning.aop.enums.PizzaEnum;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pizza {
    private Map<PizzaEnum,Integer> pizzaOrder = new HashMap<>();
}
