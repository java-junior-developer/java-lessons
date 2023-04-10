package ru.itmo.lessons.lesson12;

import ru.itmo.lessons.lesson06.books.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Lesson12 {
    public static void main(String[] args) {
        // ERROR - ошибки связаны с проблемами уровня JVM (например, нехватка памяти).
        // Ошибки нет смысла обрабатывать.

        // EXCEPTION:
        // 1. Исключения времени ВЫПОЛНЕНИЯ (наследники RuntimeException):
        // unchecked, необрабатываемые, неотслеживаемые, неконтролируемые.
        // Разработчики могут (по своему усмотрению) обработать данный тип исключений.

        // 2. Исключения времени КОМПИЛЯЦИИ (все остальные наследники Exception):
        // checked, обрабатываемые, отслеживаемые, контролируемые.
        // Разработчики обязаны обработать данный тип исключений.

        // Исключения времени выполнения
        int a = 1;
        int b = 0;
        int res = 0;
        // res = a / b; // java.lang.ArithmeticException
        System.out.println(res);

        int[] ints = new int[3];
        // ints[30] = 100; // java.lang.ArrayIndexOutOfBoundsException
        System.out.println(Arrays.toString(ints));

        String string = null;
        /*
        if (string.equals("null")) { // java.lang.NullPointerException
            System.out.println("Строка содержит null");
        }
        */

        Object object = "123";
        String stringObject = (String) object;
        System.out.println(stringObject.toUpperCase());
        // Book book = (Book) object; // java.lang.ClassCastException
        // book.setTitle("Исключения в Java");

        // Исключения времени компиляции

        // Files.delete(Path.of("file.txt")); // throw new IOException()

        // ОБРАБОТКА ИСКЛЮЧЕНИЙ любого типа (unchecked / checked)

        int x = 60, y = 0;
        int result = 0;
        try { // в блок try помещается потенциально опасный код,
              // который может привести к исключению
            result = x / y; // throw new java.lang.ArithmeticException()
        } catch (ArithmeticException exception){ // перехватывает исключение
            // указанного в нем типа (в данном случае ArithmeticException) и его наследников
            System.out.println(exception.getMessage());
        }
        System.out.println(result);


        try {
            readFromJsonFile("file.txt");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }

        // class someException01 extends Exception {} - исключение времени компиляции
        // class someException02 extends RuntimeException {} - исключение времени выполнения

        // TODO::
        //  1. объявить класс CalculatorException - исключение времени компиляции,
        //  * конструктор должен принимать на вход сообщение и
        //  передавать его в соответствующий конструктор родителя
        //  * переопределить метод String getMessage(); на своё усмотрение
        //  2. Объявить класс Operations с набором статических методов:
        //  * plus - возвращает результат сложения положительных чисел,
        //  если числа не положительные необходимо выбросить CalculatorException
        //  * minus - возвращает результат вычитания положительных чисел,
        //  если числа не положительные необходимо выбросить CalculatorException
        //  * random - возвращает случайное число в диапазоне от min до max
        //  3. Вызвать методы в точке входа

        try {
            System.out.println(Operations.random(12, 90));
        } catch (CalculatorException e) {
            // throw new CalculatorException(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }


        // TODO::
        //  Объявить метод static void throwException(Status status) throws JarException, FileNotFoundException, AccessDeniedException,
        //  которы принимает на вход enum и выбрасывает следующие исключения в зависимости от значения status:
        //  1. если status FILE_NOT_FOUND, выбрасывает FileNotFoundException
        //  2. если status ACCESS_DENIED, выбрасывает AccessDeniedException
        //  3. если status JAR_ERROR, выбрасывает JarException.
        //  При вызове метода throwException обработать исключения следующим образом:
        //   FileNotFoundException - выводить в консоль стек трейс,
        //   AccessDeniedException* - выводить в консоль сообщение исключения (метод getMessage()) и выбрасывать исключение времени выполнения,
        //   JarException* - выводить в консоль стек трейс.
        //  enum с необходимыми константами нужно создать.

    }

    // import java.io.IOException;
    public static void readFromJsonFile(String fileName) throws IOException {
        if (!fileName.endsWith(".json")) {
            // исключение времени компиляции
            throw new IOException("Программа работает только с файлами типа json");
        }
        System.out.println("Чтение из json файла");
    }
}
