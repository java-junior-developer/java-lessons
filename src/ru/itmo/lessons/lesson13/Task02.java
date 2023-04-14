package ru.itmo.lessons.lesson13;

import java.io.Serializable;

interface Eatable extends Serializable {
}

interface Runnable {
}

class Animal implements Runnable {
}

class Cat extends Animal implements Eatable {
}

class Kitten extends Cat {
}

class Dog extends Animal implements Serializable {
}

public class Task02 {
    public static <T extends Cat & Eatable> void void01(T object) {
        // ВОПРОС: методы каких типов можно вызвать у object ???
        // ОТВЕТ: методы Cat и Eatable + их супертипов, т.е.
        // Cat,
        // Eatable,
        // Animal (родитель Cat),
        // Object (родитель Cat),
        // Runnable (т.к. Animal implements Runnable),
        // Serializable (т.к. Eatable extends Serializable).
    }

    public static <T extends Animal & Serializable> void void02(T object) {
        // ВОПРОС: методы каких типов можно вызвать у object ???
        // ОТВЕТ: методы Animal и Serializable + их супертипов, т.е.
        // Animal,
        // Serializable
        // Object (родитель Animal),
        // Runnable (т.к. Animal implements Runnable)
    }

    public static <T extends Serializable & Runnable> void void03(T object) {
        // ВОПРОС: методы каких типов можно вызвать у object ???
        // ОТВЕТ:
        // Serializable,
        // Runnable,
        // Object
    }

    public static void main(String[] args) {

        // можно использовать типы, которы одновременно и Cat, и Eatable (Cat & Eatable)
        Task02.<Cat>void01(new Cat());
        Task02.<Cat>void01( new Kitten());
        Task02.<Kitten>void01(new Kitten());

        // можно использовать типы, которы одновременно и Animal, и Serializable (Animal & Serializable)
        Task02.<Cat>void02(new Cat());
        Task02.<Cat>void02(new Kitten());
        Task02.<Dog>void02(new Dog());
        Task02.<Kitten>void02(new Kitten());

        // можно использовать типы, которы одновременно и Runnable, и Serializable (Serializable & Runnable)
        Task02.<Dog>void03(new Dog());
    }
}
