package ru.itmo.lessons.lesson21.task01;

public class NutritionFacts {
    private int calories;
    private int servings;
    private int fat;
    private int proteins;
    private int carbs;

    private NutritionFacts(Builder builder){
        calories = builder.calories;
        fat = builder.fat;
        servings = builder.servings;
        proteins = builder.proteins;
        carbs = builder.carbs;
    }

    public static class Builder {
        private int calories;
        private int servings = 100;
        private int fat = -1;
        private int proteins = -1;
        private int carbs = -1;
        public Builder(int calories){
            this.calories = calories;
        }

        public Builder servings(int value) {
            servings = value;
            return this;
        }
        public Builder fat(int value) {
            fat = value;
            return this;
        }
        public Builder carbs(int value) {
            carbs = value;
            return this;
        }
        public Builder proteins(int value) {
            proteins = value;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }
}
