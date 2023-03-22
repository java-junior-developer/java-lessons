package lesson04;

public class Lesson04 {
    public static void main(String[] args) {
        // char (примитивный тип данных) 16 бит - символ Unicode
        char char01 = 'J'; // сам символ в одинарных! кавычках,
        // но "J" - строка, ссылочный тип String
        char char02 = 74; // номер символа в таблице Unicode в диапазоне от 0 до 65535
        char char03 = '\u0044'; // 16ричное представление в escape последовательности

        System.out.print(char01);
        System.out.print(char02);
        System.out.print(char03);

        System.out.println('\uD83D');
        System.out.println('\uDC38');
        System.out.println("\uD83D\uDC38" /* \n */ ); // суррогатная пара

        // каждый символ юникода может быть представлен одним char или парой (суррогатная пара) char

        // Строка - упорядоченнавя последовательность символов в двойных кавычках
        // Строка - ссылочный тип, экземпляр класса String
        // Создание строк:
        // 1. в двойных кавычках
        // 2. через конструктор new String() - используется только, если первый вариант невозможен
        // Строки неизменны, можно создать новую строку на основе существующей
        // "строка" -> "СТРОКА" -> "Строка"
        // Хранение строк до java 9: массив char в кодировке UTF-16, где каждый char был представлен 2мя байтами
        // Хранение строк с java 9 (компактные строки): массив byte в кодировке UTF-16 или LATIN-1

        String string01 = "Строка";
        String string02 = "Строка";
        String string03 = new String("Строка");

        // ссылочные типы хранятся в heap (куча) памяти
        // в heap (куча) памяти находится пул строк

        System.out.println(string01 == string02); // true (ссылки на один объект в пуле)
        System.out.println(string01 == string03); // false (сылка на разные объекты (в пуле и в куче))

        // ссылочные типы не сравниваются через ==, тк оператор сравнивает ссылки
        // (возвращает true, если переменные ссылаются на одну область памяти),
        // значения при этом не сравниваются

        string02 = null;
        System.out.println(string02 == null); // на null можно проверять через ==

        // интернирование строк - строка помещается в пул строк
        String internString = string03.intern();
        string03 = null;

        System.out.println(string01 == internString); // true (ссылки на один объект в пуле)


        string01 = "Строка";
        string02 = "СТроКА";

        // сравнение строк
        System.out.println(string01.equals(string02)); // сравнение строк с учетом регистра
        System.out.println(string01.equalsIgnoreCase(string02)); // сравнение без учета регистра

        if (string01.equals(string02)) {
            System.out.println("Строки равны");
        } else {
            System.out.println("Строки различаются");
        }

        string01 = "Строка";
        string02 = null;

        // System.out.println(string02.equals(string01)); // java.lang.NullPointerException

        if (string02 != null) System.out.println(string02.equals(string01));

        // конкатенация строк
        string01 = "Java";
        string02 = "Python";

        // + эквивалентен созданию строки через конструктор,
        // если обращение к строкам происходит через переменные
        String concatString = string01 + " :: " + string02;
        // String concatString = "Java" + " :: " + "Python"; -> "Java :: Python"
        System.out.println(concatString);

        // concat эквивалентен созданию строки через конструктор
        concatString = string01.concat(" :: ").concat(string02);
        System.out.println(concatString);

        // в циклах нельзя использовать +, метод concat и другие методы,
        // которые приводят к созданию новых объектов

        // Для создания длинных строк принято использовать
        // StringBuilder - один поток
        // или
        // StringBuffer - несколько потоков
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i).append(" "); // CharSequence
        }
        concatString = sb.toString();

















    }
}



