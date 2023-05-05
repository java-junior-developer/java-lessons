package ru.itmo.lessons.lesson22.chain;

public class Stop extends Action{
    @Override
    void execute() {
        System.out.println("Stop");
    }
}
