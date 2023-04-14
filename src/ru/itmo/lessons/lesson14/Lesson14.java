package ru.itmo.lessons.lesson14;

import ru.itmo.lessons.lesson14.task.task01.Fruit;

import java.util.*;

public class Lesson14 {
    public static void main(String[] args) {
        // ArrayList / LinkedList
        ArrayList<String> countries = new ArrayList<>(); // создан пустой список (экземпляр ArrayList)
        System.out.println(countries.size()); // 0

        countries.add("australia"); // добавление в конец списка
        countries.add("brazil"); // добавление в конец списка
        countries.add("italy"); // добавление в конец списка
        countries.add("france"); // добавление в конец списка
        countries.add("germany"); // добавление в конец списка

        countries.add(0, "spain"); // добавление элемента по индексу 0, остальные элементы сдвинулись

        countries.set(0, "turkey"); // замена элемента с индексом 0 на "turkey"

        System.out.println(countries);

        if (countries.contains("italy")) System.out.println("страна содержится в коллекции");
        if (countries.remove("brazil")) System.out.println("страна удалена из коллекции");

        String removed = countries.remove(3); // удален элемент с индексом 3
        System.out.println(removed); // france

        System.out.println(countries);

        String firstCountry = countries.get(0); //  вернет ссылку на элемент с индексом 0
        System.out.println(firstCountry); // "turkey"

        countries.trimToSize(); // внутренний массив по количеству элементов (метод недоступен для LinkedList)


        // HashSet / LinkedHashSet
        HashSet<String> uniqueCountries = new HashSet<>(countries); // создано множество (экземпляр HashSet),
        // в которое попали элементы из списка countries

        if (uniqueCountries.add("italy")) System.out.println("страна добавлена");
        else System.out.println("страна не была добавлена"); // страна уже содержится в множестве

        if (uniqueCountries.add("japan")) System.out.println("страна добавлена"); // страны не было в множестве
        else System.out.println("страна не была добавлена");

        System.out.println(uniqueCountries.size()); // 6

        System.out.println(uniqueCountries);


        // TreeSet
        TreeSet<String> sortedCountries = new TreeSet<>(uniqueCountries); // страны будут храниться в отсортированном порядке.
        // Добавить страны в TreeSet удалось, т.к. класс String реализует (имплементирует) интерфейс Comparable,
        // в классе String реализован его абстрактный метод compareTo, который определяет наименьшую строку.
        // TreeSet использует данный метод для сортировки строк

        System.out.println(sortedCountries);

        Comparator<Fruit> fruitComparator = new Fruit.PriceComparator().thenComparing(new Fruit.NameComparator());
        TreeSet<Fruit> fruitTreeSet = new TreeSet<>(fruitComparator); // создано пустое множество, порядок сортировки
        // элементов будет определять экземпляр fruitComparator
        fruitTreeSet.add(new Fruit(Fruit.FruitType.BANANA, 200, 5));
        fruitTreeSet.add(new Fruit(Fruit.FruitType.APPLE, 120, 18));
        fruitTreeSet.add(new Fruit(Fruit.FruitType.APPLE, 140, 8));
        fruitTreeSet.add(new Fruit(Fruit.FruitType.PEAR, 120, 22));
        fruitTreeSet.add(new Fruit(Fruit.FruitType.BANANA, 88, 13));
        fruitTreeSet.add(new Fruit(Fruit.FruitType.APRICOT, 300, 4));

        System.out.println(fruitTreeSet);


        // Перебор коллекций (цикл foreach)
        // попытка удаление элемента в цикле приведет к ConcurrentModificationException
        ArrayList<String> upperCountries = new ArrayList<>();

        for (String country : uniqueCountries) {
            // на каждой итерации цикла переменная country - ссылка на элемент коллекции uniqueCountries
            upperCountries.add(country.toUpperCase());
        }
        System.out.println(upperCountries);


        HashSet<Fruit> fruitHashSet = new HashSet<>();
        for (Fruit fruit : fruitTreeSet) {
            // на каждой итерации цикла переменная fruit - ссылка на элемент коллекции fruitTreeSet
            if (fruit.getCount() > 5) fruitHashSet.add(fruit);
        }
        System.out.println(fruitHashSet);


        // Перебор коллекций (iterator)
        // позволяет удалять элементы коллекции в цикле
        // может быть заменен методом removeIf

        Iterator<Fruit> fruitIterator = fruitTreeSet.iterator();
        while (fruitIterator.hasNext()) {
            Fruit fruitElem = fruitIterator.next();
            if (fruitElem.getCount() < 3) fruitIterator.remove();
        }
        System.out.println(fruitTreeSet);


    }
}

















