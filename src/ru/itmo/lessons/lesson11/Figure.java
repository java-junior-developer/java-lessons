package ru.itmo.lessons.lesson11;

import java.util.Arrays;
import java.util.Objects;

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
    public /* protected */ Figure /* Object */ clone() {
        // super.clone()
        Figure figure = new Figure(points.length); // super.clone()
        figure.ind = ind;
        for(int i = 0; i < points.length; i++) {
            if (points[i] == null) continue;
            figure.points[i] = points[i].clone();
        }
        return figure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return ind == figure.ind && Arrays.equals(points, figure.points);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(ind);
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
