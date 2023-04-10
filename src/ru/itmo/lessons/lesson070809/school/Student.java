package ru.itmo.lessons.lesson070809.school;

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

// класс Student имплементирует интерфейс ILearn
// разрешена имплементация нескольких интерфейсов через запятую
// все абстрактные методы должны быть реализованы
// default методы можно переопределить
public final class Student extends Person implements ILearn{
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

    // переопределение метода (родителя, класса Person)
    @Override // аннотация @Override времени компиляции
    public void setAge(int studentAge) {
        // при необходимости можно вызвать метод родителя
        // super.setAge(studentAge);
        if (studentAge < 7) {
            throw new IllegalArgumentException("Exception: age < 7");
        }
        this.age = studentAge;
    }

    @Override
    public void rest() {
        System.out.println("реализация метода rest класса Student");
    }

    // реализация абстрактного метода интерфейса ILearn
    @Override
    public void learn(int level){
        System.out.println("Студент " + name +
                " проходит обучение." + " Предмет " + subject);
        this.level = (int) (Math.random() * level);
    }

}