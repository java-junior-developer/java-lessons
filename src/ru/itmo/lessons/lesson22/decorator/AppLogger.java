package ru.itmo.lessons.lesson22.decorator;

public interface AppLogger { // общий для классов с основным и дополнительным функционалом
    void log(String message);
}
