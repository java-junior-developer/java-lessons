package ru.itmo.lessons.lesson07.school;

// Student наследуется от класса Person
// Student - дочерний класс
// Person - родительский класс / суперкласс
// множественное наследование классов запрещено
// class A extends B, C {} - ошибка
// class A extends B {}
// class B extends C {}

// от final класса нельзя наследоваться
// final class X {}
// class Y extends X {} - ошибка

// protected - доступ из текущего и дочернего класса
// отсутствие модификатора (package-private) - доступ из текущего,
// дочернего класса и внутри текущего пакета
public final class Student extends Person {
    private String subject; // изучаемый предмет
    private int level; // уровень знаний

    public Student(String name, String subject) {
        super(name); // вызов конструктора родительского класса
        setSubject(subject);
    }

    public void setSubject(String subject) {
        if (subject == null || subject.length() < 2) {
            throw new IllegalArgumentException("Exception: subject.length < 2");
        }
        this.subject = subject;
    }
    public String getSubject() {
        return subject;
    }
    public int getLevel() {
        return level;
    }

}