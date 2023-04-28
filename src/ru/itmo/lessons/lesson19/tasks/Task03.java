package ru.itmo.lessons.lesson19.tasks;

import ru.itmo.lessons.lesson11.Figure;
import ru.itmo.lessons.lesson14.task.task01.Fruit;

import java.util.Optional;

public class Task03 {
    public static boolean isFruitValid(Fruit fruit) {
        return Optional.ofNullable(fruit)
                .filter(f -> f.getCount() >  5)
                .filter(f -> f.getPrice() <= 100)
                .isPresent();
    }
    public static void main(String[] args) {
        // Задания на методы Optional:
        // 1. написать метод, который принимает на вход тип фрукта, стоимость и количество
        // и возвращает Optional контейнер с экземпляром типа Fruit
        // или Optional контейнер с null ссылкой, если тип фрукта == null, а стоимость или количество меньше 1

        // 2. написать метод, который принимает на вход экземпляр типа Fruit
        // и возвращает true, если передан не null, количество фруктов (getCount) больше 5,
        // а стоимость не больше 100 (getPrice)
        // Вместо обычных проверок использовать тип Optional и подходящие методы

        // 3. написать метод, который принимает на вход экземпляр типа Fruit
        // и возвращает
        // название фрукта (FruitType.getName()) в Optional контейнере, если тип фрукта определен,
        // и Optional контейнер с null ссылкой, если тип фрукта == null
        // Вместо обычных проверок использовать тип Optional и подходящие методы
    }


}


