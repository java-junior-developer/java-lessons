package ru.itmo.lessons.lesson17.task01;

public class HeadAttack implements Attack {
    @Override
    public void action(Unit unit) {
        System.out.println("Unit HeadAttack");
    }
}
