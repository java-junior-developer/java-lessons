package ru.itmo.lessons.lesson24;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {
    transient public final String title = "Сотрудник";
    private String name;
    private double salary;
    private final LocalDate hired;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.hired = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHired() {
        return hired;
    }

    public void changeSalary(double salary) {
        this.salary = salary;
    }
}

