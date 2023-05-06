package ru.itmo.lessons.lesson22.decorator;

abstract public class BaseDecorator implements AppLogger{ // родительский класс декораторов
    private AppLogger logger; // ссылка на декоратор или основной функционал

    public BaseDecorator(AppLogger logger) {
        this.logger = logger;
    }

    @Override
    public void log(String message) {
        logger.log(message);
    }

}
