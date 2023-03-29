package ru.itmo.lessons.lesson07.school;

public class Person {
    protected String name;
    protected int age;

    public Person(String name) {
        /*if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("Exception: name.length < 3");
        }
        this.name = name;*/
        setName(name);
    }

    public void setName(String name){
        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("Exception: name.length < 3");
        }
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Exception: age < 0");
        }
        this.age = age;
    }
}
