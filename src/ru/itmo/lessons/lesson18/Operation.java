package ru.itmo.lessons.lesson18;

@FunctionalInterface // аннотация времени компиляции, компилятор сообщит об ошибке,
// если в интерфейсе будет объявлено больше одного метода без реализации
public interface Operation { // функциональный интерфейс содержит один абстрактный метод
    // и любое количество методов с реализацией (static или default)
    /* public */ double action(double a, double b);
}
