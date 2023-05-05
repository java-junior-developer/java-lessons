package ru.itmo.lessons.lesson21.task03;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Action run = new Run();
        Action stop = new Stop();
        Action walk = new Walk();

        run.nextAction(stop);
        stop.nextAction(walk);
        // run.nextAction = stop, stop.nextAction = walk, walk.nextAction = null

        run.doAction();
        // run.execute
        // stop.doAction
        // stop.execute
        // walk.doAction
        // walk.execute


        // Если синтаксис языка и логика программы позволяют,
        // абстрактный класс можно заменить на функциональный интерфейс,
        // а конкретные реализации описать через лямбда выражения
        IAction runLambda = () -> System.out.println("Run Lambda");
        IAction stopLambda = () -> System.out.println("Stop Lambda");
        IAction walkLambda = () -> System.out.println("Walk Lambda");

        runLambda.next(stopLambda).next(walkLambda).execute();
    }
}
