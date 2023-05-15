package ru.itmo.lessons.lesson24;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class Company {
    private final String title;
    private Set<Manager> managers;
    private Predicate<Manager> condition;

    public Company(String name, Predicate<Manager> condition) {
        this.title = name;
        managers = new HashSet<>();
        this.condition = condition;
    }

    public String getName() {
        return title;
    }

    public void changeCondition(Predicate<Manager> newCondition){
        this.condition = newCondition;
    }

    public void addManager(Manager manager) {
        if (condition.test(manager)) {
            managers.add(manager);
            System.out.println(manager.getName() + " принят на работу в компанию " + title);
        } else {
            System.out.println("компания " + title + " не может Вас нанять");
        }
    }
    // остальной код...
}
