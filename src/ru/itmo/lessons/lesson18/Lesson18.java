package ru.itmo.lessons.lesson18;

import ru.itmo.lessons.lesson14.task.task01.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lesson18 {
    public static void main(String[] args) {
        // /* public */ double action(double a, double b);
        Operation plus01 = new Operation() {
            @Override
            public double action(double a, double b) {
                return a + b;
            }
        };

        //
        Operation plus = (first, second) -> /* return */ first + second;
        // создается анонимный класс, имплементирующий Operation,
        // реализация абстрактного метода - лямбда выражение
        // создается экземпляр анонимного класса
        System.out.println(plus.action(34.9, 78.7));

        // написать реализации для вычитания и умножения
        Operation minus = (first, second) -> first - second;
        System.out.println(minus.action(34.9, 90.2));

        printResult(plus);
        printResult(minus);
        printResult((a, b) -> a * b);

        Operation div = (a, b) -> {
            if (b == 0) return 0;
            return a / b;
        };
        System.out.println(div.action(3.8, 9.9));

        // () ->
        // x ->
        // (x) ->
        // (x, y) ->

        // (x, y) -> x + y; // неявный return
        // (x, y) -> { return x + y;}
        // (x, y) -> { несколько инструкций; }

        // import java.util.function.*;
        // Predicate
        // Function
        // Consumer
        ArrayList<Integer> integers =
                new ArrayList<>(Arrays.asList(34, -78, 12, 56, 34, -89, 0, 344));

        // boolean test(T t);
        Predicate<Integer> negative = integer -> integer < 0;
        System.out.println(negative.test(12));

        integers.removeIf(negative);


        ArrayList<String> strings = new ArrayList<>(
                Arrays.asList("01.txt", "02.json", "03.txt", "04.txt", "05.properties"));

        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit(Fruit.FruitType.APPLE, 120, 5));
        fruits.add(new Fruit(Fruit.FruitType.BANANA, 80, 12));
        fruits.add(new Fruit(Fruit.FruitType.APRICOT, 300, 2));
        fruits.add(new Fruit(Fruit.FruitType.APPLE, 120, 10));
        fruits.add(new Fruit(Fruit.FruitType.PEAR, 180, 2));
        fruits.add(new Fruit(Fruit.FruitType.PEAR, 180, 8));
        fruits.add(new Fruit(Fruit.FruitType.BANANA, 130, 8));





    }

    public static void printResult(Operation operation){
        System.out.println(operation.action(34, 89));
    }
}
