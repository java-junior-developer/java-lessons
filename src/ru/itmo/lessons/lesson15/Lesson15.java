package ru.itmo.lessons.lesson15;

import java.util.*;

public class Lesson15 {
    public static void main(String[] args) {
        // HashMap / LinkedHashMap

        // String - тип данных ключей, Integer - тип данных значений
        HashMap<String, Integer> customers = new HashMap<>();

        customers.put("Москва", 790); // добавление пары
        customers.put("Ростов", 240); // добавление пары
        customers.put("Великий Новгород", 20); // добавление пары
        customers.put(null, null); // добавление пары
        customers.put("Ростов", 300); // добавление пары, значение будет перезаписано, т.к. ключ уже содержится в map
        customers.put("Самара", 560); // добавление пары

        System.out.println(customers.size());

        customers.remove(null); // удаление по ключу
        customers.remove("Ростов", 300); // удаление по ключу и значению. Пара будет удалена, т.к. ключ содержится в map
        // и ему соответствует переданное значение - 300
        customers.remove("Москва", 240); // удаление по ключу и значению. Пара будет удалена, ключ содержится в map,
        // но ему не соответствует переданное значение

        System.out.println(customers.size());

        customers.replace("Москва", 800); // заменит значение по ключу
        customers.replace("Великий Новгород", 20, 18); // замена значения по ключу и значению.
        // Значение будет заменено, т.к. ключ содержится в map и ему соответствует переданное значение - 20

        System.out.println(customers);

        // получение значений по ключу (не удаление)
        // если ключ не найден, вернет null
        System.out.println(customers.get("Москва")); // 800
        System.out.println(customers.get("Ростов")); // null

        // если ключ не найден, вернет значение по умолчанию
        System.out.println(customers.getOrDefault("Москва", -1)); // 800
        System.out.println(customers.getOrDefault("Ростов", -1)); // -1

        if (customers.containsKey("Санкт-Петербург")) System.out.println("Информация о городе содержится в map");
        if (customers.containsValue(1000)) System.out.println("В map есть значение 1000");


        // EnumMap
        EnumMap<AppRole, String> enumMap = new EnumMap<>(AppRole.class); // ссылка на класс перечисления
        // значения хранятся в массиве - values = [null, null],
        // ключе в EnumMap не хранятся
        enumMap.put(AppRole.USER, "Пользователь");
        // в массив значений добавляется элемент "Пользователь",
        // индекс равен индексу элемента перечисления
        // Role.USER.ordinal(); -> 0
        // values[Role.USER.ordinal()] = "Пользователь"
        // values: ["Пользователь", null]
        enumMap.put(AppRole.ADMIN, "Администратор");
        // в массив значений добавляется элемент "Администратор",
        // индекс равен индексу элемента перечисления
        // Role.ADMIN.ordinal(); -> 1
        // values[Role.ADMIN.ordinal()] = "Администратор"
        // values: ["Пользователь", "Администратор"]
        System.out.println(enumMap.get(AppRole.USER)); // "Пользователь"
        // сначала определяется индекс ключа в перечислении,
        // потом по данному индексу извлекается значение из массива
        // values[Role.USER.ordinal()] -> "Пользователь"
        // enumMap.put(null, null); ошибка, нельзя использовать null в качестве ключей

        System.out.println(enumMap);

        // TreeMap
        TreeMap<String, Integer> sortedCustomers = new TreeMap<>(customers);
        // пары будут храниться в отсортированном по городам порядке.
        // Добавить пары в TreeSet удалось, т.к. класс String (тип данных ключей) реализует (имплементирует) интерфейс Comparable,
        // в классе String реализован его абстрактный метод compareTo, который определяет наименьшую строку.
        // TreeMap использует данный метод для сортировки ключей
        System.out.println(sortedCustomers);
        // sortedCustomers.put(null, null); ошибка, нельзя использовать null в качестве ключей
        // sortedCustomers.get(null); ошибка, т.к. ключи не могут быть null

        // Перебор пар map
        for (Map.Entry<String, Integer> pair : customers.entrySet()) {
            if (pair.getValue() > 500) System.out.println(pair.getKey());
            // pair.getKey() - ключ
            // pair.getValue() - ассоциированное с ним значение
        }

    }
    public enum AppRole {
        USER, ADMIN
    }
}