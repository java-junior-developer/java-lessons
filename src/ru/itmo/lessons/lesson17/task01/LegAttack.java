package ru.itmo.lessons.lesson17.task01;

public class LegAttack implements Attack {
    @Override
    public void action(Unit unit) {
        System.out.println("Unit LegAttack");
    }
}
