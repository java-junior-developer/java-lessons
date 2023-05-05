package ru.itmo.lessons.lesson22.strategy;

public interface IAction<T> { // общий тип для похожих действия
    void execute(T t);
}
