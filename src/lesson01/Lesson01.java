package lesson01;

//  однострочный комментарий
/*
многострочный комментарий
*/

// Имя класса должно соответствовать имени файла,
// Имя класса начинается с заглавной буквы,
// если имя состоит из несколькоих слов, то каждое последующее тоже
// с заглавной буквы (PascalCase)
public class Lesson01 {
    // psvm + Enter
    // метод main - точка входа в программу
    public static void main(String[] args) {
        // sout + Enter
        // вывод данных в консоль
        System.out.println("Lesson 1");

        // переменные
        // Объявление переменных: тип_данных имяПеременной (CamelCase)
        int size; // объявили переменную типа int с именем size
        size = 1000; // переменной size присвоили значение 1000
        System.out.println(size);

        int count = 750;
        count = 620;
        System.out.println(count);

        /*int length = 300;
        int width = 450;*/

        // можно объявлять переменные одного типа в одну инструкцию
        int length = 300, width = 450;

        length = 900_100; // при записи чисел можно использовтаь _
        // для удобства чтения
        System.out.println(length);

        // byte someData = 213;

        long bigData01 = 8001;
        long bigData02 = 800_000_000_000L; // если значение переменой
        // типа long выходит за пределы int,
        // в конце необходимо ставить L или l

        double temp01 = 12.9;
        float temp02 = 12.9F; // необходимо добавлять F или f
        // для указания типа float

        // System.out.println(bigData01 / 0); // Ошибка
        // System.out.println(temp01 / 0); // Infinity

        boolean isActive = true;
        boolean isClose = false;

        // приведение типов
        // 1. автоматическое
        // 2. явное

        int height01 = 1900;
        long height02 = height01; // автоматическое приведение типов

        // int smallValue01 = 10;
        // byte smallValue02 = smallValue01;

        int smallValue01 = 10078;
        byte smallValue02 = (byte) smallValue01;

        int a = 10, b = 13;
        int c01 = a / b; // результат деления целых чисел - целое число
        System.out.println(c01); // 0

        double c02 = (double) (a / b); // 0.0
        double c03 = (double) a / b;
        System.out.println(c03); // 0.7692307692307693

        int x = 90;
        long y = 10000;
        long c04 = x * y;

        // сложение byte или short дает int

    }
}
