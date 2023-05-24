package ru.itmo.lessons.lesson28;

public class PutThread extends Thread /* implements Runnable */{
    private int sum;
    private BankAccount account;

    public PutThread(int sum, BankAccount account) {
        this.sum = sum;
        this.account = account;
    }

    @Override
    public void run() {
        account.putMoney(sum);
    }
}
