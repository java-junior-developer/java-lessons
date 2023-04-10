package ru.itmo.lessons.lesson0708.school;

public class Headmaster implements ILearn{
    public void invite(Person person){
        System.out.println("Директор вызвал " + person.getName());
    }

    @Override
    public void learn(int level) {
        System.out.println("Директор посетил урок. " +
                "Уровень знаний преподавателя " + level);
    }
}
