package ru.itmo.lessons.lesson11;

public class Lesson11 {
    public static void main(String[] args) {
        Point point01 = new Point(12, -33);
        Point point02 = new Point(12, -33);

        System.out.println(point01);
        // System.out.println(point01.toString());
        System.out.println(point02);
        // System.out.println(point02.toString());

        System.out.println(point01 == point02); // false
        System.out.println(point01.equals(point02)); // true

        // все классы в java наследуются от класса Object

        Figure figure01 = new Figure(2);
        figure01.addPoint(point01);
        figure01.addPoint(point02);
        System.out.println(figure01);
    }
}
