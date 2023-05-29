package ru.itmo.lessons.lesson30;

public class PutThread extends Thread {
    private int sum;
    private final BankAccount account;

    public PutThread(int sum, BankAccount account) {
        this.sum = sum;
        this.account = account;
    }

    @Override
    public void run() {
        account.putMoney(sum);
    }
}
