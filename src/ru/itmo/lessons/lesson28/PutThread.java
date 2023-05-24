package ru.itmo.lessons.lesson28;

import java.util.Scanner;

public class PutThread extends Thread /* implements Runnable */{
    private int sum;
    private BankAccount account;

    public PutThread(int sum, BankAccount account) {
        this.sum = sum;
        this.account = account;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму");
        int s = scanner.nextInt();
        account.putMoney(s);
        account.putAddMoney(s * 2);
    }
}
