package ru.itmo.lessons.lesson11;

import java.util.Arrays;

public class Figure {
    private final Point[] points;
    private int ind;

    public Figure(int pointsLen) {
        if (pointsLen < 2) pointsLen = 2;
        points = new Point[pointsLen];
    }

    public void addPoint(Point point) {
        if (point == null) {
            System.out.println("null не может быть добавлен в массив");
            return;
        }
        if (points.length == ind){
            System.out.println("массив заполнен");
            return;
        }
        points[ind] = point;
        ind++;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
