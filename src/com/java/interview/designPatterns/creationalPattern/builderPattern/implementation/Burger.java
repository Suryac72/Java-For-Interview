package com.java.interview.designPatterns.creationalPattern.builderPattern.implementation;

public class Burger {

    private final String bun;
    private final String patty;
    private final boolean cheese;
    private final boolean mayo;
    private final boolean lettuce;
    private final boolean tomato;
    private final String drink;

    private Burger(Builder builder) {
        this.bun = builder.bun;
        this.patty = builder.patty;
        this.cheese = builder.cheese;
        this.mayo = builder.mayo;
        this.lettuce = builder.lettuce;
        this.tomato = builder.tomato;
        this.drink = builder.drink;
    }

    @Override
    public String toString() {
        return "Burger { bun='" + bun + "', patty='" + patty + "', cheese=" + cheese +
                ", mayo=" + mayo + ", lettuce=" + lettuce + ", tomato=" + tomato +
                ", drink='" + drink + "' }";
    }

    public static class Builder {
        private String bun;
        private String patty;
        private boolean cheese;
        private boolean mayo;
        private boolean lettuce;
        private boolean tomato;
        private String drink;

        public Builder setBun(String bun) {
            this.bun = bun;
            return this;
        }

        public Builder setPatty(String patty) {
            this.patty = patty;
            return this;
        }

        public Builder addCheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public Builder addMayo(boolean mayo) {
            this.mayo = mayo;
            return this;
        }

        public Builder addLettuce(boolean lettuce) {
            this.lettuce = lettuce;
            return this;
        }

        public Builder addTomato(boolean tomato) {
            this.tomato = tomato;
            return this;
        }

        public Builder setDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public Burger build() {
            return new Burger(this);
        }
    }
}
