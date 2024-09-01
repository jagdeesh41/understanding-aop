package com.learning.aop.enums;

public enum BurgerEnum {
    HAMBURGER(200),
    CHEESE_BURGER(150),
    VEG_BURGER(100),
    NON_VEG_BURGER(350);

    final int cost;

    BurgerEnum(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
