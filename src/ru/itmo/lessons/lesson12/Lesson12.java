package ru.itmo.lessons.lesson12;

import ru.itmo.lessons.lesson06.books.Book;

import java.io.IOException;
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
        int res;
        res = a / b;
        System.out.println(res);

        int[] ints = new int[3];
        ints[30] = 100;
        System.out.println(Arrays.toString(ints));

        String string = null;
        if (string.equals("null")) System.out.println("Строка содержит null");

        Object object = "123";
        String stringObject = (String) object;
        System.out.println(stringObject.toUpperCase());
        Book book = (Book) object;
        book.setTitle("Исключения в Java");

        // Исключения времени компиляции

        // Files.delete(Path.of("file.txt")); // IOException

        // ОБРАБОТКА ИСКЛЮЧЕНИЙ любого типа (unchecked / checked)

        int x = 60, y = 0;
        int result = 0;
        try { // в блок try помещается потенциально опасный код,
            // который может привести к исключению
            result = x / y;
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
