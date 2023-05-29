package ru.itmo.lessons.lesson30;

import java.util.ArrayList;
import java.util.concurrent.*;

public class MondayLesson {
    public static void main(String[] args) throws InterruptedException {

        String[] tokens = {"fr3vgrg", "3wvjiwg"};

        Semaphore tokenSemaphore = new Semaphore(tokens.length, true);

        RequestThread requestThread = new RequestThread(tokens, tokenSemaphore);

        /*for (int i = 0; i <= 10; i++) {
            new Thread(new RequestThread(tokens, tokenSemaphore)).start();
        }*/

        ArrayList<Future<DataFromServer>> dataContainers = new ArrayList<>();
        int numberOfThreads = 2 * Runtime.getRuntime().availableProcessors() + 1;

        ExecutorService requestPool = Executors.newFixedThreadPool(numberOfThreads);

        // передача задач на выполнение
        for (int i = 0; i < 10; i++) {
            Future<DataFromServer> dataContainer = requestPool.submit(requestThread);
            dataContainers.add(dataContainer);
        }

        // получение результатов
        for (Future<DataFromServer> dataContainer : dataContainers) {
            try {
                System.out.println("Ожидание получения данных");
                DataFromServer dataFromServer = dataContainer.get();
                // DataFromServer dataFromServer = dataContainer.get((long) (Math.random() * 2000), TimeUnit.MILLISECONDS));
                System.out.println("Данные получены: " + dataFromServer.getName());
            } catch (InterruptedException | ExecutionException /*| TimeoutException*/ e) {
                e.printStackTrace();
            }
        }
        requestPool.shutdown();

        BankAccount account = new BankAccount();

        int sum = 0;

        ArrayList<PutThread> putThreads = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            int randomSum = (int) (Math.random() * 3000);
            sum += randomSum;
            putThreads.add(new PutThread(randomSum, account));
        }

        for (PutThread putThread : putThreads) {
            putThread.start();
        }

        for (PutThread putThread : putThreads) {
            putThread.join();
        }

        System.out.println(account.getBalance());
        System.out.println(sum);

    }
}