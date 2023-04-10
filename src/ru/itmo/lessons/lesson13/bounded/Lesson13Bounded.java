package ru.itmo.lessons.lesson13.bounded;

public class Lesson13Bounded {
    public static void main(String[] args) {
        Train train01 = new Train("train01", 7);

        Car car01 = new Car(Repaintable.Color.ORANGE, "car01");

        Bus bus01 = new Bus("bus01");

        Service service = new Service();
    }
}
