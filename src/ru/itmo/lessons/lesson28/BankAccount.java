package ru.itmo.lessons.lesson28;

public class BankAccount {
    private int money;

    public int getMoney() {
        return money;
    }

    public void putMoney(int value){
        if (value > 0) money += value;
    }
}
