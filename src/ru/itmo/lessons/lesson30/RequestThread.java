package ru.itmo.lessons.lesson30;

import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class RequestThread implements Callable<DataFromServer> /* Runnable */ {
    private ReentrantLock reentrantLock;
    private final String[] tokens;
    private final Semaphore semaphore;

    public RequestThread(String[] tokens, Semaphore semaphore) {
        this.tokens = tokens;
        this.semaphore = semaphore;
        this.reentrantLock = new ReentrantLock(true);
    }

    @Override
    public DataFromServer call /* void run */() {
        DataFromServer data = null;
        System.out.println("Поток " + Thread.currentThread().getName() +
                " готов отправить запрос. Нужен токен.");

        try {
            // запрос разрешения на токен
            semaphore.acquire();

            String token = null;
            int tokenIndex = -1;

            /*if (reentrantLock.isLocked()) {
                System.out.println("Ресурс уже заблокирован");
                System.out.println("Очередь к ресурсу: " + reentrantLock.getQueueLength());
            } else {
                System.out.println("Ресурс еще свободен");
            }*/

            /*boolean isLocked = reentrantLock.tryLock(100, TimeUnit.MILLISECONDS);
            if (isLocked) System.out.println("Удалось получить блокировку");
            else System.out.println("Ресурс не был освобожден");*/

            reentrantLock.lock();
            //synchronized (tokens) {
            try {


                for (int i = 0; i < tokens.length; i++)
                    // если есть свободные токены
                    if (tokens[i] != null) {
                        // берем токен
                        token = tokens[i];
                        tokens[i] = null;
                        tokenIndex = i;
                        System.out.println("Поток " + Thread.currentThread().getName() + " получил токен.");
                        break;
                    }
            } finally {
                reentrantLock.unlock();
            }
            //}
            // запрос на сервер, получение данных и нового токена
            Thread.sleep((int) (Math.random() * 10 + 1) * 1000);
            System.out.println("Поток " + Thread.currentThread().getName() + " использует токен " + token);
            data = new DataFromServer(Thread.currentThread().getName());
            System.out.println("Поток " + Thread.currentThread().getName() + " получил данные и новый токен.");

            // добавление нового токена в массив
            synchronized (tokens) {
                tokens[tokenIndex] = token;
            }

            // освобождение ресурса
            semaphore.release();
            System.out.println("Поток " + Thread.currentThread().getName() + " завершил работу.");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        /* System.out.println(data.getName()); */
        return data;
    }
}