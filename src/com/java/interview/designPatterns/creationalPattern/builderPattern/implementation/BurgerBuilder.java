package com.java.interview.designPatterns.creationalPattern.builderPattern.implementation;


/**
 * Deliberately bad BurgerBuilder: mutable, re-usable, no validation.
 * Shows how reusing a builder or forgetting validation can create broken objects.
 */
public class BurgerBuilder {

    // mutable fields (bad)
    public String bun;
    public String patty;
    public boolean cheese;
    public boolean mayo;
    public boolean lettuce;
    public String drink;

    public BurgerBuilder setBun(String bun) {
        this.bun = bun;
        return this;
    }

    public BurgerBuilder setPatty(String patty) {
        this.patty = patty;
        return this;
    }

    public BurgerBuilder addCheese(boolean cheese) {
        this.cheese = cheese;
        return this;
    }

    public BurgerBuilder addMayo(boolean mayo) {
        this.mayo = mayo;
        return this;
    }

    public BurgerBuilder addLettuce(boolean lettuce) {
        this.lettuce = lettuce;
        return this;
    }

    public BurgerBuilder setDrink(String drink) {
        this.drink = drink;
        return this;
    }

    /**
     * Build without validation — returns possibly incomplete Burger.
     * Uses the public Burger.Builder to construct the final object.
     */
    public Burger build() {
        return new Burger.Builder()
                .setBun(this.bun)
                .setPatty(this.patty)
                .addCheese(this.cheese)
                .addMayo(this.mayo)
                .addLettuce(this.lettuce)
                .setDrink(this.drink)
                .build();
    }
}
