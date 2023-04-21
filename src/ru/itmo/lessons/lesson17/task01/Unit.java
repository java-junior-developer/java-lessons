package ru.itmo.lessons.lesson17.task01;

import java.util.HashMap;

public class Unit {
    private Unit enemy;
    private HashMap<String, Action<Unit>> actions;

    public Unit() {
        this.actions = new HashMap<>();
    }

    public void setEnemy(Unit enemy) {
        this.enemy = enemy;
    }

    public Unit getEnemy() {
        return enemy;
    }

    public Unit move(Move moveAction){
        moveAction.action(this);
        return this;
    }

    public Unit attack(Attack attackAction){
        attackAction.action(enemy);
        return this;
    }



    public Unit save(String name, Action<Unit> action){
        actions.put(name, action);
        return this;
    }
}
