package ru.itmo.lessons.lesson22.decorator;

public class ConsoleWriter implements AppLogger{ // основной функционал
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
