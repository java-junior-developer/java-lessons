package ru.itmo.lessons.lesson28.task;

public class Bank {

    public void transferMoney(Account src, Account dst, int money){
                                                        // 78 90
        Thread transaction01 = new Thread(new Transaction(src, dst, money));
        transaction01.start();
                                                         // 90 78
        Thread transaction02 = new Thread(new Transaction(dst, src, money));
        transaction02.start();
    }
}