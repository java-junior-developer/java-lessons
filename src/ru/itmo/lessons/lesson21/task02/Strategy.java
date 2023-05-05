package ru.itmo.lessons.lesson21.task02;

public class Strategy {
    public static void main(String[] args) {
        IAction<Unit> run = new Run();
        IAction<Unit> stop = new Stop();
        IAction<Unit> walk = new Walk();

        Unit unit = new Unit();
        unit.move(stop);


        unit.move(run);

        unit.move(walk);
    }
}
