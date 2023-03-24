package lesson05;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson05 {
    public static void main(String[] args) {
        // String res01 = str01 + str02 + str03 + str04; // 3 строки

        // StringBuilder sb = new StringBuilder();
        // String res02 = sb.append(str01).append(str02).append(str03).append(str04).toString(); // 1 строка


        int a = 78, b = 87;
        System.out.println(a == b); // false - разные значения

        Scanner scanner01 = new Scanner(System.in);
        Scanner scanner02 = new Scanner(System.in);
        System.out.println(scanner01 == scanner02); // false - ссылки на разные обрасти памяти

        // Массивы
        int[] codes = {544, 231, 700, 533, 455};
        System.out.println(codes[3]); // 533
        System.out.println(codes[1]); // 231
        // System.out.println(codes[10]); // выход за пределы массива -
        // java.lang.ArrayIndexOutOfBoundsException (ошибка времени выполнения)

        // длина массива - количество элементов массива, неотрицательное значение типа int
        // длину массива нельзя изменить
        System.out.println(codes.length); // 5

        // вывести в консоль значение последнего элемента массива
        System.out.println(codes[codes.length-1]); // 455

        // вывести в консоль случайный элемент массива. Индекс определить, используя Math.random()
        int randIndex = (int) (Math.random() * codes.length);
        System.out.println(codes[randIndex]);
        System.out.println(codes[(int) (Math.random() * codes.length)]);

        // перебор массива в цикле
        // дает возможность перебрать массив различными способами:
        // от 1го элемента к последнему, от последнего к первому и т.д.
        // дает возможность изменять значения элементов массива
        for (int i = 0; i < codes.length; i++) { // с переменной i ассоциирован индекс элемента массива
                                                 //  имя переменной может быть любым
            System.out.println(codes[i]); // codes[i] - обращение к элементу массива по индексу
            if (codes[i] < 1000) codes[i] += 1000;
        }

        // iter
        // последовательный перебор элементов массива от 1го к последнему
        // не позволяет изменять значения элементов массива
        for (int code : codes) { // codes - перебираемый массив
            // int code -> где int - тип элементов массива
            // code - значение элемента массива (копия для примитивов, ссылка для ссылочных типов)
            System.out.println(code);
        }

        // массив со значениями по умолчанию
        int[] ints01 = new int[10]; // где 10 - длина массива
        String[] colors = new String[4]; // где 4 - длина массива
        // длина массива может задаваться через переменную или выражение

        // byte, short, int, long - 0
        // float, double - 0.0
        // boolean - false
        // все ссылочные типы - null

        // 1) заменить дефолтные значения массива ints01 случайными числами в диапазоне [0;30)
        // Для замены использовать цикл!
        // 2) заменить дефолтные значения массива colors любыми цветами.
        // Вывести в консоль информацию о том, содержит ли массив красный цвет

        // ints01 -> [0,0,0,0,0,0,0,0,0,0]
        for (int i = 0; i < ints01.length; i++) {
            ints01[i] = (int) (Math.random() * 30);
        }

        // colors -> [null, null, null, null]
        colors[0] = "blue"; // [blue, null, null, null]
        colors[2] = "red"; // [blue, null, red, null]
        colors[3] = "black"; // [blue, null, red, black]


        for (String color : colors) {
            // if (color == null) continue;
            /*
            if (color != null && color.equalsIgnoreCase("red")) {
                System.out.println("В массиве содержится красный цвет");
                break;
            }
            */
            if ("red".equalsIgnoreCase(color)) {
                System.out.println("В массиве содержится красный цвет");
                break;
            }
        }

        System.out.println(colors);

        // Класс Arrays содержит методы для работы с массивами
        System.out.println(Arrays.toString(colors));

        // методы для работы с массивами
        double[] temps = {45.7, 22.9, 12.0, 33.8, 98.1};
        // СОРТИРОВКА
        Arrays.sort(temps); // меняет исходный массив
        System.out.println(Arrays.toString(temps));

        // БИНАРНЫЙ ПОИСК [12.0, 22.9, 33.8, 45.7, 98.1]
        System.out.println(Arrays.binarySearch(temps, 98.1)); // 4
        System.out.println(Arrays.binarySearch(temps, 6)); // -1

        // СОЗДАНИЕ КОПИЙ
        // 1) Позволяет сделать полную копию массива
        double[] newTemps01 = temps.clone();
        System.out.println(Arrays.toString(newTemps01));

        // 2) Позволяет скопировать несколько первых элементов массива или сделать полную копию массива
        double[] newTemps02 = Arrays.copyOf(temps, 3);
        System.out.println(Arrays.toString(newTemps02));

        // 3) System.arraycopy(Object src, int srcPos, Object dst, int dstPos, int len)
        // Метод копирует len элементов массива src, начиная с позиции srcPos,
        // в массив dst, начиная с позиции dstPos.
        // Массив dst должен иметь достаточный размер, чтобы в нем поместились все копируемые элементы.
        // [12.0, 22.9, 33.8, 45.7, 98.1]
        double[] newTemps03 = new double[30];
        System.arraycopy(temps, 0, newTemps03, 10, temps.length);
        System.out.println(Arrays.toString(newTemps03));

        // МНОГОМЕРНЫЕ МАССИВЫ
        int[][] ints02 = {
                {1, 4, 7},
                {22, 88, 89, 76},
        };
        System.out.println(ints02[1][3]); // 76
        System.out.println(ints02[0][0]); // 1

        int[][] ints03 = new int[3][2]; // [[0,0],[0,0],[0,0]]
        ints03[0][0] = 10;
        ints03[1][0] = 100;

        for (int i = 0; i < ints03.length; i++) {
            for (int j = 0; j < ints03[i].length; j++) {
                ints03[i][j] = (int) (Math.random() * 1000);
            }
        }
        System.out.println(Arrays.deepToString(ints03));

        String[][] animals = new String[3][]; // [null, null, null]
        animals[0] = new String[2]; // [[null, null], null, null]
        animals[1] = new String[3]; // [[null, null], [null, null, null], null]
        animals[2] = new String[4]; // [[null, null], [null, null, null], [null, null, null, null]]

        System.out.println(Arrays.deepToString(animals));

    }
}
