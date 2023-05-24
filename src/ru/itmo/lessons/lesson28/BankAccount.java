package ru.itmo.lessons.lesson28;

public class BankAccount {
    private int money;
    private int addMoney;

    public int getMoney() {
        return money;
    }

    public void putMoney(int value){
        if (value > 0) money += value;
    }

    public void putAddMoney(int value){
        if (value > 0) addMoney += value;
    }
}
