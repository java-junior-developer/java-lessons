package ru.itmo.lessons.lesson24;

import java.util.HashSet;

public class Manager extends Employee {
    public final String title = "Управляющий";
    private double bonus;
    private HashSet<Employee> people;

    public Manager(String name, double salary, int numberOfPeople) {
        super(name, salary);
        this.bonus = numberOfPeople * 1000;
        people = new HashSet<>(numberOfPeople);
    }

    public void upBonus(int bonus){
        this.bonus += bonus;
    }

    public void addNewPerson(Employee employee) {
        people.add(employee);
    }

    public int getNumberOfEmployees() {
        return people.size();
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }
    // остальной код...
}
