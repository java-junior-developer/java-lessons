package ru.itmo.lessons.lesson070809.school;

// нельзя создать экземпляры abstract класса
// может содержать абстрактные методы (без реализации),
// которые необходимо реализовать в дочерних не abstract классах
abstract public class Person {
    protected String name;
    protected int age;

    public Person(String name) {
        /*if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("Exception: name.length < 3");
        }
        this.name = name;*/
        setName(name);
    }

    // final c аргументами (локальными переменными) означают,
    // что данные можно использовать только для чтения
    // (нельзя изменить значение примитива и ссылку для объекта)
    // final метод нельзя переопределить в дочернем классе
    public final void setName(String name){
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


    // абстрактный метод (без реализации, без { })
    abstract public void rest();
}
