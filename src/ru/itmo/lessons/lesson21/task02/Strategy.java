package ru.itmo.lessons.lesson21.task02;

public class Strategy {
    public static void main(String[] args) {
        IAction<Unit> run = new Run();
        IAction<Unit> stop = new Stop();
        IAction<Unit> walk = new Walk();

        Unit unit = new Unit(stop);
        unit.move();

        unit.changeAction(run);
        unit.move();

        unit.changeAction(walk);
        unit.move();
    }
}
