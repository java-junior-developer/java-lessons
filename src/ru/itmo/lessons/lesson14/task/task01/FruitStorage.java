package ru.itmo.lessons.lesson14.task.task01;

import java.util.ArrayList;
import java.util.List;

public class FruitStorage {
    private ArrayList<Fruit> fruits; // коллекция для хранения фруктов (коллекцию выбрать самостоятельно)


    public FruitStorage() {
        fruits = new ArrayList<>(); // коллекция для хранения фруктов (коллекцию выбрать самостоятельно)
    }

    public void addFruit(Fruit newFruit) {
        if (newFruit == null) return;
        for (Fruit fruit : fruits) {
            if (fruit == newFruit) return;
            if (fruit.equals(newFruit)) {
                fruit.setCount(fruit.getCount() + newFruit.getCount());
                return;
            }
        }
        fruits.add(newFruit);
        // добавление фрукта newFruit в коллекцию fruits
        // newFruit не может быть null
        // newFruit не может быть ссылкой на элемент коллекции
        // Если в коллекции fruits уже есть фрукт с типом и ценой, как у newFruit,
        // увеличивать значение свойства count
        // фрукта из коллекции на значение свойства count объекта newFruit
        // В противном случае просто добавлять newFruit в коллекцию fruits
    }

    public int getNumberOfFruitsByType(Fruit.FruitType fruitType) {
        // возвращает количество фруктов типа fruitType
        if (fruits.size() == 0) return 0;
        int count = 0;
        for (var fruit : fruits) {
            if (fruit.getType() == fruitType) {
                count += fruit.getCount();
            }
        }
        return count;
    }

    public int getNumberOfFruits() {
        // возвращает количество всех фруктов (цикл не использовать)
        // FIXME:
        //  1. Объявить свойство в текущем классе, которое будет хранить количество фруктов
        //  2. При каждом добавлении фрукта в хранилище, вызове метода addFruit,
        //  увеличивать значение объявленного в п.1 свойства
        //  3. метод getNumberOfFruits возвращает значения свойства, объявленного в п.1
        return 0;
    }

    public void increasePrice(int value) {
        // value может быть в диапазоне [10; 30)
        // увеличить цену фруктов на value процентов
        // FIXME:
        //  1. выполнить проверку, value должно попадать в диапазон от 10 до 30,
        //  в противном случае прервать работу метода
        //  2. перебрать коллекцию fruits и на каждой итерации цикла:
        //      2.1. получить текущее значение свойства price элемента коллекции (вызовом метода метод getPrice у элемента коллекции)
        //      2.2. вычислить новое значение - текущее + value процентов
        //      2.3. установить новое значение свойства price элемента коллекции (вызовом метода метод setPrice у элемента коллекции)

    }

    public double getFruitsPrice() {
        // возвращает общую стоимость фруктов на складе
        // FIXME:
        //  1. объявить локальную переменную, которая будет хранить стоимость фруктов
        //  2. перебрать коллекцию fruits и на каждой итерации цикла:
        //      2.1. получить значение свойства price элемента коллекции (вызовом метода метод getPrice у элемента коллекции)
        //      2.2. полученное значение прибавить к значение переменой, объявленной в п.1
        //  3. значение переменной, объявленной в п.1, вернуть из метода
        return 0;
    }

    public List<Fruit> getFruitsByTypeAndPrice(Fruit.FruitType fruitType, int maxPrice) {
        // maxPrice должна быть положительной
        // возвращает список, в который войдут фрукты из коллекции fruits с типом fruitType и ценой не выше maxPrice
        // FIXME:
        //  1. выполнить проверку, значение maxPrice должно быть положительным,
        //  в противном случае прервать работу метода, вернуть null
        //  2. создать пустой список, в котором будут храниться экземпляры типа Fruit (ArrayList<Fruit>)
        //  2. перебрать коллекцию fruits и на каждой итерации цикла:
        //      2.1. получить значение свойства type элемента коллекции (вызовом метода метод getType у элемента коллекции)
        //      2.2. сравнить полученное значение со значением fruitType,
        //      если они равны, добавить элемент коллекции fruits в список созданный в п.2
        //   3. ссылку на список, в список созданный в п.2, вернуть из метода
        return null;
    }
}