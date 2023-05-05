package ru.itmo.lessons.lesson22.strategy;

public class Stop implements IAction<Unit>{ // конкретная реализация
    @Override
    public void execute(Unit unit) {
        System.out.println("Stop");
    }
}
