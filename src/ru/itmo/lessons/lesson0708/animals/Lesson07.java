package ru.itmo.lessons.lesson0708.animals;

public class Lesson07 {

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
         Cat cat01 = new Cat(12, 67); // 12, 67, [null, null, null, ... ]
         Cat cat02 = new Cat(18, 55); // 18, 55, [null, null, null, ... ]
         cat02.setName("Гришка");

         cat01.catchMouse(mouse01);

         cat02.attack(cat01);
    }


}
