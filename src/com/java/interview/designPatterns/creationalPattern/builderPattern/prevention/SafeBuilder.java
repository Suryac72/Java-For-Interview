package com.java.interview.designPatterns.creationalPattern.builderPattern.prevention;

import com.java.interview.designPatterns.creationalPattern.builderPattern.implementation.Burger;

public class SafeBuilder {

    public static class Builder {

        private final String bun;   // mandatory
        private final String patty; // mandatory

        private boolean cheese;
        private boolean mayo;
        private String drink;

        public Builder(String bun, String patty) {
            if (bun == null || patty == null)
                throw new IllegalArgumentException("bun and patty are required!");
            this.bun = bun;
            this.patty = patty;
        }

        public Builder addCheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public Builder addMayo(boolean mayo) {
            this.mayo = mayo;
            return this;
        }

        public Builder setDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public Burger build() {
            return new Burger.Builder()
                    .setBun(bun)
                    .setPatty(patty)
                    .addCheese(cheese)
                    .addMayo(mayo)
                    .setDrink(drink)
                    .build();
        }
    }
}
