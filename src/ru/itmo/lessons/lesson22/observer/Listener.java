package ru.itmo.lessons.lesson22.observer;

public interface Listener { // общий тип для всех наблюдателей за экземплярами Connection
    void execute(Connection connection);
}
