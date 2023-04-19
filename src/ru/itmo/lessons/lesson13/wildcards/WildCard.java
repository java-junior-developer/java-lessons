package ru.itmo.lessons.lesson13.wildcards;

import java.util.ArrayList;
import java.util.List;

interface Eatable { }

interface Runnable { }

class Animal implements Runnable { }

class Cat extends Animal implements Eatable {
    private String color;

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Cat{}";
    }
}

class Kitten extends Cat {
    @Override
    public String toString() {
        return "Kitten{}";
    }
}

class Mouse implements Eatable {
    @Override
    public String toString() {
        return "Mouse{}";
    }
}

class Dog extends Animal {
    @Override
    public String toString() {
        return "Dog{}";
    }
}
public class WildCard {
    // ? - wildcard, может использоваться при объявлении переменных:

    // 1. ограничение сверху (upper bounding)
    // <? extends Cat> - может быть Cat и любой наследник

    // 2. ограничение снизу (lower bounding)
    // <? super Cat> - может быть Cat и любой супертип

    // 3.Захват подстановочных знаков (wildcard capture)
    // <?> - может быть все, что угодно

    // метод принимает на вход списки Cat или его супертипов (Animal, Object, Eatable, Runnable)
    public static void addAnimalsLower(List<? super Cat> list, int count) {
        for (int i = 0; i < count; i++) {
            list.add(new Cat());
            list.add(new Kitten());
            // list.add(new Animal()); FIXME: ПОЧЕМУ КОМПИЛЯТОР НЕ ПОЗВОЛИТ добавить супертипы Cat, например Animal ???
        }

        // из контейнера с wildcard "? super" можно прочитать только Object
        for (Object element: list) { // FIXME: ПОЧЕМУ КОМПИЛЯТОР НЕ ПОЗВОЛИТ прочитать, например Cat ???
            System.out.println(element.toString());
        }
    }

    // метод принимает на вход списки Cat или его наследников (Kitten)
    public static void addAnimalsUpper(List<? extends Cat> list, int count) {
        // в контейнер с wildcard "? extends" можно добавить только null
        for (int i = 0; i < count; i++) { // FIXME: ПОЧЕМУ КОМПИЛЯТОР НЕ ПОЗВОЛИТ добавить ничего, кроме null ???
            // list.add(null);
        }

        for (Cat cat : list) { // FIXME: ПОЧЕМУ КОМПИЛЯТОР ПОЗВОЛИТ прочитать Cat ???
            System.out.println(cat.toString());
        }
    }

    // The Get and Put Principle или PECS (Producer ? Extends - Consumer ? Super)
    public static void whiteCats(List<? extends Cat> producer, List<? super Cat> consumer) {
        for (Cat cat : producer) {
            if ("white".equals(cat.getColor())) consumer.add(cat);
        }
    }
    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        List<Kitten> kittens = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();
        List<Eatable> eatables = new ArrayList<>();

        // метод принимает на вход списки Cat или его супертипов (Animal, Object, Eatable, Runnable)
        addAnimalsLower(animals, 3);
        addAnimalsLower(cats, 5);
        addAnimalsLower(objects, 2);
        // addAnimalsLower(kittens, 12);
        // addAnimalsLower(dogs, 12);
        addAnimalsLower(eatables, 7);

        // метод принимает на вход списки Cat или его наследников (Kitten)
        // addAnimalsUpper(animals, 4);
        addAnimalsUpper(cats, 4);
        // addAnimalsUpper(objects, 8);
        addAnimalsUpper(kittens, 12);
        // addAnimalsUpper(dogs, 4);
        // addAnimalsUpper(eatables, 5);

        whiteCats(cats, animals);
        // whiteCats(animals, cats);


        List<Animal> animalList = new ArrayList<>();
        List<? extends Animal> animalListUpper = new ArrayList<>();
        List<? super Animal> animalListLower = new ArrayList<>();
        List<?> arrayList = new ArrayList<>();


        // Ковариантность - сохранение иерархии наследования исходных типов в производных типах в том же порядке, т.е.
        // если Cat - подтип Animal, то List<Cat> - подтип List<Animal>.
        // И можно выполнить присваивание:
        Cat[] catsArr = new Cat[10]; // массивы ковариантны
        Animal[] animalsArr = catsArr;
        animalsArr[0] = new Cat();
        // НО: animalsArr[1] = new Dog(); -> ArrayStoreException - при попытке добавить неправильный тип объекта в массив

        // Инвариантность - отсутствие наследования между производными типами.
        // если Cat - подтип Animal, то List<Cat> - не подтип List<Animal> и наоборот.

        List<Cat> cats01 = new ArrayList<>(); // generic инвариантны
        // List<Animal> animals01 = cats01; FIXME: ПОЧЕМУ КОМПИЛЯТОР НЕ ПОЗВОЛИТ так присвоить ссылку ???

        // Контравариантность - изменение иерархии исходных типов на противоположную в производных типах.
        // если Cat - подтип Animal, то List<Animal> - подтип List<Cat>.
        // И можно выполнить присваивание:
        List<Animal> animals02 = new ArrayList<>();
        // List<Cat> cats02 = animals02; FIXME: ПОЧЕМУ КОМПИЛЯТОР НЕ ПОЗВОЛИТ так присвоить ссылку ???

        // ковариантность в generic
        List<Cat> cats03 = new ArrayList<>();
        List<? extends Animal> animals03 = cats03; // FIXME: ПОЧЕМУ КОМПИЛЯТОР ПОЗВОЛИТ так присвоить ссылку ???

        // контрвариантность в generic
        List<Animal> animals04 = new ArrayList<>();
        List<? super Cat> cats04 = animals04; // FIXME: ПОЧЕМУ КОМПИЛЯТОР ПОЗВОЛИТ так присвоить ссылку ???
    }
}
