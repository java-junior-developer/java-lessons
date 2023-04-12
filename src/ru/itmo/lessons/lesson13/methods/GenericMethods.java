package ru.itmo.lessons.lesson13.methods;

public class GenericMethods {
    // типизированные (generic) методы
    // могут принимать на вход и возвращать generic типы

    // generic типы существуют только на этапе компиляции
    // их нет во время выполнения программы

    // <T> указывает на то, что в методе используется generic тип (T)
    // без <T> нельзя использовать generic тип в параметрах или типе возвращаемого значения
    public static <T> boolean inArray(T[] array, T element){
        // стирание типов (type erasure):
        // 1. generic тип без ограничений (unbounded) компилируется в тип Object
        // 2. generic тип с ограничениями (bounded) компилируется в тип ограничения

        // у объектов типа T можно вызывать только методы Object
        for (T t : array) {
            if (element.equals(t)) return true;
        }
        return false;
    }

    public static <T extends Number, K extends String> int compareHashCode(T first, K second) {
        // T компилируется в Number
        // K компилируется в String

        // у generic тип с ограничениями можно вызывать методы типа - ограничения и его родителей

        // у объектов типа T (first) можно вызывать методы Number и его родителей
        // у объектов типа K (second) можно вызывать методы String и его родителей
        return Integer.compare(first.hashCode(), second.toUpperCase().hashCode());
    }
    public static void main(String[] args) {
        String[] colors = {"blue", "yellow", "red"};
        String color = "black";

        // при вызове метода в качестве T типа можно использовать
        // тип данных, указанный в <> и его наследников.
        // в данном случае только String, тк у строк нет наследников (final class String)
        System.out.println(GenericMethods.<String>inArray(colors, color));

        Integer[] integers = {45, 89, 99, -90};
        Integer integer = 45;

        // при вызове метода в качестве T типа можно использовать
        // тип данных, указанный в <> и его наследников.
        // в данном случае Byte, Short, Integer, Long, Double, Float
        System.out.println(GenericMethods.<Number>inArray(integers, integer));

        // при вызове метода public static <T> boolean inArray(T[] array, T element)
        // компилятор гарантирует использование нужного типа данных <String>, <Number> и тд
        // при вызове метода public static boolean inArray(Object[] array, Object element)
        // такой гарантии не будет

        System.out.println(GenericMethods.<Number, String>compareHashCode(12.7, "12"));

    }
}
