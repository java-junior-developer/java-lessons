package ru.itmo.lessons.lesson22.decorator;

public class Delimiter extends BaseDecorator { // дополнительный функционал (декоратор)

    public Delimiter(AppLogger logger) {
        super(logger);
    }

    @Override
    public void log(String message) {
        // добавление разделителя, передача данных дальше (следующему декоратору или основному объекту)
        super.log("====" + message + "====");
    }
}
