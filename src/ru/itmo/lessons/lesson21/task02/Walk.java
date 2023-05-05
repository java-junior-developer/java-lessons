package ru.itmo.lessons.lesson21.task02;

public class Walk implements IAction<Unit>{
    @Override
    public void execute(Unit unit) {
        System.out.println("Walk");
    }
}
