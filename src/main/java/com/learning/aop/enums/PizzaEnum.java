package com.learning.aop.enums;

public enum PizzaEnum {
    PEPPERONI(400),
    HARISSA(900);
    final int cost;
    PizzaEnum(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
