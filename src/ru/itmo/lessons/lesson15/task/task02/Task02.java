package ru.itmo.lessons.lesson15.task.task02;

import java.util.*;

public class Task02 {

    private static List<String> task01(Map<String, String> map, String someString) {
        // FIXME:
        //  1. Создать пустой список, для хранения строк (ArrayList<String>)
        //  2. Перебрать пары (ключ + значение) объекта map
        //  (для получения коллекции пар использовать метод map.entrySet(), пример перебора пар в файле Lesson15.java) и
        //   на каждой итерации цикла:
        //      2.1. получать значение пары (метод getValue())
        //      2.2. полученное значение сравнивать со значением someString, если они равны, ключ пары (метод getKey())
        //      добавлять в список, объявленный в п.1
        //   3. Список, объявленный в п.1, вернуть из метода
        return null;
    }

    private static Map<String, Integer> task02(List<String> strings) {
        // FIXME: похожую реализацию разбирали на занятии (класс UserStorage, метод getNumberOfUsersByRole)
        //  1. Создать пустую map, для хранения строк и количества повторений (HashMap<String, Integer>)
        //  2. Перебрать список strings и на каждой итерации цикла:
        //      2.1. проверять, содержится ли ключ (элемент перебираемой коллекции) в мапе, объявленной в п.1
        //      2.2. если ключ содержится (значит информация о строке из списка уже есть в мапе), получать значение по данному ключу,
        //      увеличивать его на 1, записывать в мапу ключ и новое значение (обновляем количество повторений данной строки)
        //      2.3. если ключ не содержится, записывать в мапу ключ и 1 (строка из списка встретилась первый раз)
        //   3. Мапу, объявленную в п.1, вернуть из метода
        return null;
    }

    private static Map<String, Long> task0301(String text) {
        // FIXME: реализация похожа на метод task02
        //  1. Создать пустую map, для хранения строк и количества повторений (HashMap<String, Long>)
        //  2. Создать массив строк из строки text (нужный метод найти самостоятельно)
        //  3. Перебрать массив строк, полученный в п.2 и на каждой итерации цикла:
        //      3.1. проверять, содержится ли ключ (элемент перебираемой коллекции) в мапе, объявленной в п.1
        //      3.2. если ключ содержится (значит информация о строке из списка уже есть в мапе), получать значение по данному ключу,
        //      увеличивать его на 1, записывать в мапу ключ и новое значение (обновляем количество повторений данной строки)
        //      3.3. если ключ не содержится, записывать в мапу ключ и 1 (строка из списка встретилась первый раз)
        //   4. Мапу, объявленную в п.1, вернуть из метода
        return null;
    }

    private static Map<Integer, ArrayList<String>> task0302(String text) {
        // FIXME: реализация похожа на метод getUsersByAge класса UserStorage
        //  1. Создать пустую map, для хранения строк и количества повторений (HashMap<Integer, ArrayList<String>>)
        //  2. Создать массив строк из строки text (нужный метод найти самостоятельно)
        //  3. Перебрать массив строк, полученный в п.2 и на каждой итерации цикла:
        //      3.1. получить размер строки (элемента массива)
        //      3.2. проверять, содержится ли ключ (значение полученное в п.3.1) в мапе, объявленной в п.1
        //      3.3. если ключ содержится (значит информация о строке из массива уже есть в мапе),
        //      получать значение (список) по данному ключу, добавлять строку (элемент массива) в полученный список,
        //      записывать в мапу ключ и список, с добавленной в него строкой
        //      3.4. если ключ не содержится, создавать пустой список (ArrayList<String>),
        //      добавлять в него строку (элемент массива), записывать в мапу ключ и созданный список
        //   4. Мапу, объявленную в п.1, вернуть из метода
        return null;
    }

    public static void main(String[] args) {
        // FIXME:: В решениях не использовать lambda выражения и stream API

        // TODO (2.1) написать статический метод, который принимает на вход map (например, firstTaskMap) и город (например, city),
        //  формирует и возвращает список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";

        System.out.println(task01(firstTaskMap, city));

        // TODO (2.2) дан список слов (например, words).
        //  Написать статический метод, который будет возвращать количество одинаковых слов в списке
        //  в map вида Map<String, Integer>, где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");

        System.out.println(task02(words));


        // TODO (2.3) Задания по тексту (например, text). На каждый пункт - минимум один метод (можно статический):
        //  1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
        //  (Map<String, Long>, где - ключи (String) - слово, значения (Long) - частота встречаемости)
        //  2. написать метод, который собирает все слова в группы по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        //  (Map<Integer, ArrayList<String>>, где - ключи (Integer) - количество букв, значения (ArrayList<String>) - слова)
        //  3. написать метод, который выводит в консоль топ 10 самых часто встречаемых в тексте слов (артикли и предлоги тоже считаем за слова)

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        System.out.println(task0301(text));
        System.out.println(task0302(text));
        task0303(text);

    }

    private static void task0303(String text) {
        Map<String, Integer> map = task02(Arrays.asList(text.split(" ")));
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        /*class ValueComparator implements Comparator<Map.Entry<String, Integer>> {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // из локального класса есть доступ к локальным переменным метода
                // локальные переменные доступны только для чтения
                return o2.getValue() - o1.getValue();
            }
        }
        list.sort(new ValueComparator()); */

        // анонимный класс
        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // из анонимного класса есть доступ к локальным переменным метода
                // локальные переменные доступны только для чтения
                return o2.getValue() - o1.getValue();
            }
        };
        list.sort(valueComparator);

        int count = Math.min(10, list.size());
        for (int i = 0; i < count; i++) {
            System.out.println(list.get(i).getKey() + "=" + list.get(i).getValue());
        }
    }

    // static class ValueComparator implements Comparator<Map.Entry<String, Integer>>{}
}