package ru.itmo.lessons.lesson19;

import ru.itmo.lessons.lesson14.task.task01.Fruit;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lesson19 {

    public static void main(String[] args) {
        // public interface BiFunction<T, U, R>: R apply(T t, U u);
        // public interface BinaryOperator<T>: T apply(T t1, T t2);
        BinaryOperator<Double> plus01 = (d01, d02) -> d01 + d02;
        System.out.println(plus01.apply(3.3, 4.4));
        // ИмяКласса::имяМетода - ссылка на метода
        BinaryOperator<Double> plus02 = Double::sum;
        System.out.println(plus02.apply(3.3, 4.4));

        Comparator<Fruit> byType01 = (f1, f2) -> f1.getType().compareTo(f2.getType());
        Comparator<Fruit> byType02 = Comparator.comparing(fruit -> fruit.getType());
        Comparator<Fruit> byType03 = Comparator.comparing(Fruit::getType);
        Comparator<Fruit> fruitComparator = Comparator.comparing(Fruit::getCount)
                .reversed()
                .thenComparing(Fruit::getType)
                .thenComparing(Fruit::getPrice);


        // Дан поток целых чисел:
        Stream<Integer> temps01 = Stream.of(-560, 312, 12, -55, -100, 45, 0, 0, 23, -20, 221);
        // - оставить в потоке только отрицательные элементы - filter(Predicate)
        // - отсортировать в натуральном порядке (согласно реализации метода compareTo класса Integer) - sorted
        // - выбрать 3 первых элемента - limit(int)
        // - добавить к каждому элементу строку " deg" - map(Function)
        // - вывести каждый элемент в консоль - forEach(Consumer)

        temps01.filter(integer -> integer < 0) // boolean test(T t);
                .sorted()
                .limit(3)
                .map(integer -> integer + " deg") // R apply(T t);
                .forEach(s -> System.out.println(s)); // void accept(T t);


        // Дан поток целых чисел:
        Stream<Integer> temps02 = Stream.of(-560, 45, 312, 12, -55, -100, 100, 45, 23, -20, 221, 100, 34);
        // - удалить дублирующиеся значения - distinct()
        // - отрицательные значения заменить на 0 - map(Function)
        // - отсортировать в порядке убывания - sorted(Comparator)
        // - добавить к каждому элементу строку " deg" - map(Function)
        // - привести каждую строку к верхнему регистру - map(Function)
        // - вывести элементы, кроме "0 DEG", в консоль - forEach(Consumer)
        temps02.distinct()
                .map(integer -> integer < 0 ? 0 : integer)
                .sorted(Comparator.reverseOrder())
                .map(integer -> integer + " deg")
                .map(String::toUpperCase) // R apply(T t);
                .forEach(s -> {
                    if (!s.equals("0 DEG")) System.out.println(s);
                });


        // Дан массив строк:
        String[] colors = {"white", "black", "red", "yellow", "yellowgreen", "green", "dark yellow"};
        // - создать на его основе поток строк - Arrays.stream(colors)
        // - оставить цвета, не содержащие жёлтый (yellow) оттенок - filter(Predicate)
        // - вывести в консоль количество элементов потока - count()
        long count = Arrays.stream(colors)
                .filter(str -> !str.contains("yellow"))
                .count();
        System.out.println(count);


        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit(Fruit.FruitType.APPLE, 120, 5));
        fruits.add(new Fruit(Fruit.FruitType.BANANA, 80, 12));
        fruits.add(new Fruit(Fruit.FruitType.APRICOT, 300, 2));
        fruits.add(new Fruit(Fruit.FruitType.APPLE, 120, 10));
        fruits.add(new Fruit(Fruit.FruitType.PEAR, 180, 2));
        fruits.add(new Fruit(Fruit.FruitType.PEAR, 180, 8));
        fruits.add(new Fruit(Fruit.FruitType.BANANA, 130, 8));

        // Дан список фруктов, вывести в консоль информацию,
        // если в нем останется хотя бы один фрукт с типом BANANA после:
        // - стоимость фруктов, количество которых меньше 5, увеличить в 2 раза - peek(Consumer)
        // - удалить фрукты, стоимость которых больше 100 - filter(Predicate)
        // - выяснить, есть ли бананы среди оставшихся фруктов - anyMatch(Predicate)
        // для получения потока элементов коллекции используйте метод collection.stream()
        boolean result = fruits.stream()
                .peek(fruit -> {
                    if (fruit.getCount() < 5) fruit.setPrice(fruit.getPrice() * 2);
                }) // void accept(T t);
                .filter(fr -> fr.getPrice() <= 100)
                .anyMatch(fruit -> fruit.getType() == Fruit.FruitType.BANANA);
        if (result) {
            System.out.println("В потоке остался хотя бы один фрукт с типом BANANA");
        }


        // Дан список фруктов.
        // Вывести в консоль минимальный по стоимости фрукт min(Comparator) после того,
        // как стоимость фруктов будет уменьшена на 10%, если их количество больше 10 - peek
        // для получения потока элементов коллекции используйте метод stream
        Fruit minByPrice = fruits.stream()
                .peek(fr -> {
                    if(fr.getCount() > 10) fr.setPrice(fr.getPrice() + (fr.getPrice() * 0.1));
                })
                .min(Comparator.comparing(Fruit::getPrice))
                .get();
        System.out.println(minByPrice);


        // преобразование stream в массив
        Object[] objectsArr = fruits.stream().toArray();
        Fruit[] fruitsArr = fruits.stream()
                .toArray(Fruit[]::new); // ссылка на конструктор массива типа Fruit
                // .toArray(size -> new Fruit[size]); без ссылки на конструктор

        // преобразование stream в коллекцию
        List<Fruit> fruitList = fruits.stream()
                .toList(); // или .collect(Collectors.toList());

        Set<Fruit> fruitSet = fruits.stream()
                .collect(Collectors.toSet());

        ArrayList<Fruit> fruitArrayList = fruits.stream()
                .collect(Collectors.toCollection(ArrayList::new)); // ссылка на конструктор нужной коллекции
                // или .collect(Collectors.toCollection(() -> new ArrayList<>())); // T get();

        // TreeSet<Fruit> treeSet = fruits.stream()
        //         .collect(Collectors.toCollection(TreeSet::new));

        // Function<? super T, ? extends K> keyMapper,
        // Function<? super T, ? extends U> valueMapper
        // BinaryOperator<U> mergeFunction,
        // преобразование stream в map
        Map<String, Integer> map01 = Arrays.stream(colors) // red:6 green:5
                .collect(Collectors.toMap(
                        color -> color, // R apply(T t);
                        color -> color.length(), // R apply(T t);
                        (value1, value2) -> value1 + value2 //  T apply(T t1, T t2);
                        // HashMap::new
                ));



        Map<Fruit.FruitType, List<Fruit>> map02 = fruits.stream()
                .collect(Collectors.groupingBy(fruit -> fruit.getType() // R apply(T t);
                        // Collectors.toCollection(ArrayList::new)
                ));

        Map<Fruit.FruitType, Long> map03 = fruits.stream()
                .collect(Collectors.groupingBy(fruit -> fruit.getType(),
                        // HashMap::new
                        Collectors.counting()));







    }
}
