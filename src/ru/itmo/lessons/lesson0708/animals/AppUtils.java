package ru.itmo.lessons.lesson0708.animals;

public class AppUtils {
    // метод принимающий на вход 2 числа, возвращающий минимальное
    // метод принимающий на вход 2 строки, возвращающий наименьшую по длине
    // метод принимающий на вход 2 числа (min, max),
    // возвращающий случайное от min до max
    private AppUtils(){}

    public static int getMin(int a, int b) { // AppUtils.getMin(45, 90);
        return a > b ? b : a;
    }

    public static String getMin(String firstStr, String secondStr){ // AppUtils.getMin("45", "190");
        return firstStr.length() > secondStr.length() ? secondStr : firstStr;
    }

    public static int getRandomNumber(int minNum, int maxNum){ // AppUtils.getRandomNumber(3, 9);
        return (int) ((Math.random() * (maxNum - minNum)) + minNum);
    }
}
