package ru.itmo.lessons.lesson30;

import java.util.concurrent.atomic.AtomicInteger;

// если вам просто нужно изменять одну переменную с помощью нескольких потоков,
// лучше выбирать атомарные классы
public class BankAccount {
    private final AtomicInteger balance = new AtomicInteger(0);

    public void putMoney(int value) {
        this.balance.updateAndGet(currentBalance -> currentBalance + value);
    }

    public int getBalance() {
        return balance.get();
    }
}