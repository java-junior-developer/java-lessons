package ru.itmo.lessons.lesson21.task03;

public interface IAction {
    void execute();

    default IAction next(IAction action){
        return () -> {
            execute();
            action.execute();
        };
    }
}
