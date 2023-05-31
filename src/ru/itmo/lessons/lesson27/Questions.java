package ru.itmo.lessons.lesson27;

import java.util.Scanner;

public class Questions {
    public static void main(String[] args) {

        // Thread:
        // interrupted = false ->
        // interrupt() ->
        // interrupted = true
        // InterruptedException
        // interrupted = false

        Thread scannerThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Enter your message or '/stop' for exit");
                String line = scanner.nextLine();
                if ("/stop".equals(line)) break;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(line.toUpperCase());
            }
        });
        scannerThread.start();

        try {
            Thread.sleep(100_000); // main
        } catch (InterruptedException ignored) {}

        scannerThread.interrupt(); // из main потока меняем значение свойства interrupted
        // потока (thread) на true


    }
}
