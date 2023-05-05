package ru.itmo.lessons.lesson22.observer;

public class MessageSender implements Listener{ // конкретная реализация наблюдателя
    @Override
    public void execute(Connection connection) {
        System.out.println("Отправка сообщений по смс");
    }
}
