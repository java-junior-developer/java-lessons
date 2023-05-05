package ru.itmo.lessons.lesson22.chain;

public class Unit { // использует цепочки обработчиков
    public void move(Action action){ // реализованные через абстрактный класс
        action.doAction();
    }

    public void move(IAction action) { // реализованные через функциональный интерфейс
        action.execute();
    }
}
