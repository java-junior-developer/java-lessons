package ru.itmo.lessons.lesson21.task02;

public interface IAction<T> {
    void execute(T t);
}
