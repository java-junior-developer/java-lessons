package ru.itmo.lessons.lesson17.task01;

public class StopAction implements Move {
    @Override
    public void action(Unit unit) {
        System.out.println("Unit StopAction");
    }
}
