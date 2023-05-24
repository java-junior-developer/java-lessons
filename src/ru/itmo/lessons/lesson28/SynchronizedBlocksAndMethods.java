package ru.itmo.lessons.lesson28;

import java.util.ArrayList;

public class SynchronizedBlocksAndMethods {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        int sum = 0;

        synchronized (account) {
            ArrayList<PutThread> threads = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                int randomSum = (int) (Math.random() * 3000);
                sum += randomSum;
                threads.add(new PutThread(randomSum, account));
            }

            for (PutThread thread : threads) {
                thread.start();
            }

            for (PutThread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    //throw new RuntimeException(e);
                }
            }
        }
        System.out.println(sum);
        System.out.println(account.getMoney());

        // stack память у каждого потока своя
        // heap память - общая

    }
}
