package ru.itmo.lessons.lesson07.animals;

public class Lesson07 {
    public static void main(String[] args) {
         Mouse mouse01 = new Mouse(15);
         Cat cat01 = new Cat(12, 67); // 12, 67, [null, null, null, ... ]
         Cat cat02 = new Cat(18, 55); // 18, 55, [null, null, null, ... ]
         cat02.setName("Гришка");

         cat01.catchMouse(mouse01);

         cat02.attack(cat01);
    }
}
