package ru.itmo.lessons.lesson24;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String title;
    private Set<Manager> managers;
    private CompanyCondition condition;

    public Company(String name, CompanyCondition condition) {
        this.title = name;
        managers = new HashSet<>();
        this.condition = condition;
    }

    public String getName() {
        return title;
    }

    public void changeCondition(CompanyCondition newCondition){
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
