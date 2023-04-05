package ru.itmo.lessons.lesson10.enums;

import java.util.Arrays;

public class Lesson10 {
    public static void main(String[] args) {
        Country country01 = Country.UK;
        Country country02 = Country.UK;
        // сравнение элементов перечисления через ==
        // идентично сравнению через equals и
        System.out.println(country01 == country02); // true
        System.out.println(country01 == Country.UK); // true
        System.out.println(country01 == Country.USA); // false

        Article article01 = new Article("Путешествие по Британии");
        System.out.println(article01.getCountry()); // null
        article01.setCountry(Country.UK);
        System.out.println(article01.getCountry() == country01); // true
        article01.setCountry(Country.FRANCE);

        // методы enum
        // получение массива констант
        Country[] countries = Country.values();
        System.out.println(Arrays.toString(countries));
        // [UK, USA, FRANCE]

        // индекс элемента перечисления в массиве
        System.out.println(Country.FRANCE.ordinal()); // 2
        System.out.println(article01.getCountry().ordinal()); // 2

        for (Country country : countries) {
            // методы name и toString возвращают одинаковое
            // строковое представление объекта (элемента перечисления)
            // Но: метод name нельзя переопределить, а toString можно
            System.out.println(country.name());
            System.out.println(country.toString());
        }
        // методы equals, hashCode, clone в enum переопределять нельзя

        System.out.println(Priority.HIGH.getCode());

        Priority priority = Priority.MEDIUM;
        System.out.println(priority.getCode());

        Priority[] priorities = Priority.values();
        for (Priority priorityElem : priorities) { // iter
            System.out.println(priorityElem.getCode());
        }
    }
}

// объявить класс Article со свойствами: название и страна,
