package ru.itmo.lessons.lesson0708.school;

public final class Teacher extends Person implements ITeach{
    private final String subject;
    private int level;
    public Teacher(String subject, int level, String name){
        super(name);
        this.subject = subject;
        this.level = level;
    }

    public String getSubject() {
        return subject;
    }

    public int getLevel() {
        return level;
    }

    // переопределить метод setAge родителя
    @Override
    public void setAge(int age) {
        if (age < 25) {
            throw new IllegalArgumentException("Exception: age < 25");
        }
        this.age = age;
    }

    @Override
    public void rest() {
        System.out.println("реализация метода rest класса Teacher");
    }

    @Override
    public void teach(ILearn student){
        // можно вызвать только методы, объявленные в ILearn
        student.defaultLearning();
        student.learn(this.level);
    }
}
