package ru.itmo.lessons.lesson07.animals;

public class Cat {
    private String name = "безымянный";
    private final int speed;
    private final int weight;
    private final Mouse[] mice;
    private int index; // 0

    private long winner;
    public Cat(int speed, int weight){
        if (speed < 10) {
            throw new IllegalArgumentException("Exception: speed < 10");
        }
        if (weight < 50) {
            throw new IllegalArgumentException("Exception: weight < 50");
        }
        this.speed = speed;
        this.weight = weight;
        mice = new Mouse[100];
    }

    public void setName(String name) {
        // написать проверку для name
        this.name = name;
    }

    public void catchMouse(Mouse mouse) {
        if (mouse == null) {
            System.out.println("Кот ловит только мышей");
            return;
        }
        if (speed <= mouse.speed) {
            System.out.println(name + " не смог поймать мышь");
            return; // прерывает работу метода
        }
        if (mice.length == /*>=*/ index) {
            System.out.println(name + " кот поймал достаточное количество мышей");
            return;
        }
        mice[index] = mouse;
        index++;
    }

    public void attack(Cat enemy){
        if (enemy == null) {
            System.out.println("Кот может напасть только на кота");
            return;
        }
        if (enemy == this) {
            System.out.println("Кот не должен нападать сам на себя");
            return;
        }
        if (weight > enemy.weight) winner++;
        else enemy.winner++;
    }
}
