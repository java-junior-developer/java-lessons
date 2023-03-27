package ru.itmo.lessons.lesson06.books;

// public класс доступен из любого участка папки с исходным кодом
// в файле может быть только один public класс верхнего уровня
// имя public класса должно соответствовать имени файла
public class Author { // ru.itmo.lessons.lesson06.books.Author
    // свойства, характеристики, поля, атрибуты
    // Значения свойств по-умолчанию:
    // для ссылочных типов - null
    // для целых чисел - 0
    // для чисел с плавающей точкой - 0.0
    // для типа boolean - false
    // модификатор доступа ТипДанных имяСвойства;
    public String name;
    public String surname;

    // методы
    // модификатор доступа
    // Тип Данных возвращаемого значения (указанного после return)
    // имя метода
    // () с параметрами
    // { } - тело метода, инструкции,
    // которые будут выполнены при вызове метода
    public String getFullName(){
        String fullName = name + " " + surname;
        return fullName; // return name + " " + surname;
        // return используется, чтобы вернуть результат работы метода
        // return прерывает работу метода
    }

    public void printFullName(){
        // return; прерывает работу метода
        System.out.println(name + " " + surname);
    }


}


