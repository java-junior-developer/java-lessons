package ru.itmo.lessons.lesson30;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Lesson30 {
    public static void main(String[] args) throws InterruptedException {
        /*
        // сами по себе не являются потоками
        Callable<String> callableTask = () -> "string";
        Runnable runnableTask = () -> System.out.println("string");

        // возвращает результат работы метода
        // может выбросить исключение времени компиляции
        String taskResult01 = callableTask.call();

        // не возвращает результат работы метода
        // не может выбросить исключение времени компиляции
        runnableTask.run();

        // можно напрямую передать в конструктор Thread,
        // инструкции из run будут выполняться в отдельном потоке
        Thread thread01 = new Thread(runnableTask);
        thread01.start();

        // нельзя передать в конструктор Thread
        Thread thread02 = new Thread(callableTask);
        thread02.start();

        ExecutorService pool = Executors.newSingleThreadExecutor();
        // можно передать пулу потоков
        // инструкции из run будут выполняться в отдельном потоке
        pool.execute(runnableTask);

        // можно передать пулу потоков
        // инструкции из call будут выполняться в отдельном потоке
        // результат работы метода call будет сохранен во Future контейнере
        Future<String> containerForTaskResult = pool.submit(callableTask);

        // вызывающий (main в данном случае) ждет,
        // пока данные поступят в контейнер
        try {
            // String taskResult02 = containerForTaskResult.get();
            String taskResult02 = containerForTaskResult.get(10000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            System.out.println("Ошибка возникла во время выполнения задачи. " +
                    "Данные не будут получены");
        } catch (TimeoutException e) {
            System.out.println("Данные не были получены за 10000 млс. " +
                    "main больше не будет ждать");
        }
        // pool:
        // потоки [t1]
        // задачи [runnableTask, callableTask]
        // после передачи задачи в очередь пула: callableTask -> Future[null]

        // containerForTaskResult.get(); - main ждет, пока в контейнере появится строка

        // после завершения задачи: callableTask -> Future["строка"]
        */

        String[] tokens = {"fr3vgrg", "3wvjiwg"};

        Semaphore tokenSemaphore = new Semaphore(tokens.length, true);

        // Одна блокировка (ReentrantLock) на несколько потоков.
        // Если поток захватывает блокировку методами lock или tryLock,
        // другие потоки приостанавливают работу на моменте вызова lock или tryLock
        // и не могут выполнять инструкции дальше.
        // То есть, блокируется не сам ресурс и ожидающие его потоки,
        // как в synchronized блоке или методе,
        // а потоки, которые не успели получить блокировку (ReentrantLock)
        // Когда поток отпускает блокировку (ReentrantLock), методом unlock,
        // один поток, из ожидающих на моменте вызова lock или tryLock,
        // получает блокировку (ReentrantLock), остальные продолжают ждать.
        ReentrantLock reentrantLock = new ReentrantLock(true);

        RequestThread requestThread = new RequestThread(tokens, tokenSemaphore, reentrantLock);

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
                // DataFromServer dataFromServer =
                // dataContainer.get(200_000L, TimeUnit.MILLISECONDS));
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