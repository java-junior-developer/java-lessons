package ru.itmo.lessons.lesson17.task01;

public class House {
    public House act(Action<House> action) {
        action.action(this);
        return this;
    }
}