package ru.itmo.lessons.lesson09.animals;

public class Lesson09 {

    // static
    // со свойсвами
    // с методами: фабричные методы, создающие и возвращающие объекты
    // вспомогательные, обслуживающие методы
    // static методы нельзя переопределить,
    // из static методов нельзя обращаться с не static свойствам и
    // вызывать не static методы
    // с классами (только вложенными)
    // static блок
    public static void main(String[] args) {
         Mouse mouse01 = Mouse.getMouse();
         Cat cat01 = Cat.getCat();
         Cat cat02 = Cat.getCat();
         cat02.setName("Гришка");

         cat01.catchMouse(mouse01);

         cat02.attack(cat01);
    }


}
