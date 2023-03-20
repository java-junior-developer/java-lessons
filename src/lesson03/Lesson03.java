package lesson03;

import java.util.Scanner;

public class Lesson03 {
    public static void main(String[] args) {
        // Инкремент (++) / Декремент (--)
        int a = 1;
        System.out.println(a++); // 1 // постфиксная форма
        System.out.println(a); // 2

        a = 1;
        System.out.println(++a); // 2 // префиксная форма
        System.out.println(a); // 2

        a = 1;
        System.out.println(a--); // 1 // постфиксная форма
        System.out.println(a); // 0

        a = 1;
        System.out.println(--a); // 0 // префиксная форма
        System.out.println(a); // 0

        a += 1;
        a -= 1;

        a = a + 1;
        a = a - 1;

        // пользовательский ввод
        Scanner in = new Scanner(System.in); // объявлять до циклов
        System.out.println("Введите целое число");
        int userNumber = in.nextInt();
        System.out.println(userNumber * userNumber);

        // Циклы (while, for, do while)
        // +++++

        // System.out.print("+");
        int printsCount = 5;

        while (printsCount > 0) /* булевое выражение / условие */ { // тело цикла
            System.out.println("+++++");
            printsCount--;
        }

        /*boolean isActive = false;
        while (isActive) { ни одной итерации
            System.out.println("Программа запущена");
        }*/

        /*boolean isActive = true;
        while (isActive) { бесконечный цикл
            System.out.println("Программа запущена");
        }*/

        if (userNumber == 0) { // если пользователь введет 0
            System.out.println("Пользователь ввёл 0");
        } else if (userNumber < 0) { // если пользователь введет отрицательное число
            System.out.println("Пользователь ввёл число меньше 0");
        }


        else {
            System.out.println("Пользователь ввёл число больше 0");
        }

        while (true) {
            System.out.println("Введите целое положительное" +
                    " число или 0 для выхода из программы");
            userNumber = in.nextInt();
            if (userNumber == 0) { // если пользователь введет 0
                break; // выход из текущего цикла
            }
            /* else */ if (userNumber < 0) { // если пользователь введет отрицательное число
                continue; // переход на следующую итерацию к проверке условия в круглых скобках
            }
            // инструкциии будут выполнены, если пользователь введет положительное число
            /* else if (userNumber > 0) */ System.out.println(userNumber * userNumber);
        }

        // TODO: Задача на цикл while
        Scanner taskScanner = new Scanner(System.in);
        // Считать с консоли количество тарелок и моющего средства
        // (тип данных переменных определить самостоятельно).

        // На каждой итерации цикла моющее средство расходуется из расчета 0.5 на 1 тарелку.
        // В цикле выводить сколько моющего средства осталось после мытья каждой тарелки.

        // После цикла вывести сколько тарелок и моющего средства осталось.

        // При решении задачи не использовать бесконечный цикл.

        System.out.println("Введите количество тарелок. Целое число.");
        int plates = taskScanner.nextInt();
        System.out.println("Введите количество средства. Дробное число.");
        double fairy = taskScanner.nextDouble();

        while (plates > 0 && fairy >= 0.5) {
            plates--;
            fairy -= 0.5;
            System.out.println(fairy);
        }
        System.out.println(plates);
        System.out.println(fairy);

        // for (;;) {}
        /*int printsCount = 5;

        while (printsCount > 0) *//* булевое выражение / условие *//* { // тело цикла
            System.out.println("+++++");
            printsCount--;
        }*/
        for (int printsCount01 = 5; printsCount01 > 0; printsCount01--) { // тело цикла
            System.out.println("+++++");
            System.out.println(printsCount01);
        }

        // TODO: Задача на цикл for
        // Вывести все неотрицательные элементы последовательности 30 25 20 15 10 и т.д.
        // fori
        for (int i = 30; i >= 0 ; i = i - 5) {
            System.out.println(i);
        }

    }
}
