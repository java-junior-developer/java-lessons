package ru.itmo.lessons.lesson12;

public class Operations {
    public static int plus(int a, int b) throws CalculatorException{
        if (a < 0 || b < 0) {
            throw new CalculatorException("Числа д.б. положительные");
        }
        return a + b;
    }


    public static int minus(int a, int b) throws CalculatorException{
        if (a < 0 || b < 0) {
            throw new CalculatorException("Числа д.б. положительные");
        }
        return a - b;
    }


    public static int random(int min, int max) throws CalculatorException{
        return (int) (min + Math.random() * minus(max, min));
    }
}
