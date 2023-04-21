package ru.itmo.lessons.lesson17.task01;

public class Construction implements Action<House> {

    @Override
    public void action(House house) {
        System.out.println("House Construction");
    }
}