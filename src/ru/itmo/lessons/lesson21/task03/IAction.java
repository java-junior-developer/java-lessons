package ru.itmo.lessons.lesson21.task03;

public interface IAction { // вместо абстрактного класса
    void execute(); // вместо abstract void execute();

    default IAction next(IAction action){ // вместо Action nextAction(Action next) + void doAction()
        return () -> {
            execute();
            action.execute();
        };
    }
}
