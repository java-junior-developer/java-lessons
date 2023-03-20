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

        while (true) {
            System.out.println("Введите целое положительное" +
                    " число или 0 для выхода из программы");
            userNumber = in.nextInt();
            if (userNumber == 0) break; // выход из текущего цикла
            if (userNumber < 0) {
                continue; // переход на следующую итерацию
            }
            System.out.println(userNumber * userNumber);
        }

        // Считать с консоли количество тарелок и моющего средства
        // (тип данных переменных определить самостоятельно).

        // На каждой итерации цикла моющее средство расходуется из расчета 0.5 на 1 тарелку.
        // В цикле выводить сколько моющего средства осталось после мытья каждой тарелки.

        // После цикла вывести сколько тарелок и моющего средства осталось.

        // При решении задачи не использовать бесконечный цикл.
    }
}
