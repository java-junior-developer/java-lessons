package ru.itmo.lessons.lesson29.executors;

import java.util.List;
import java.util.concurrent.*;


public class Lesson29ThreadPools {
    public static void main(String[] args) {
        // пул потоков (реализация паттерна 'объектный пул')
        // команды [c1, c2, c3]
        // c1.execute()
        // c2.execute()
        // c3.execute()

        // пул потоков
        //    потоки: [t1, (t2), t3]
        //    задачи: [runnable6]

        // все потоки пула run() {
        //   задачи.take().run();
        // }

        // Можно создать пул:
        // 1. фиксированного размера - количество потоков неизменно
        // 2. гибкого размера - указывается минимальное (== изначальное) и
        // максимальное количество потоков. Создание дополнительных потоков
        // зависит от наличия задач в очереди.
        // Необходимо наследование от ThreadPoolExecutor
        // 3. пул для выполнения задач с указанным интервалом

        // [t1, t2, t3]
        // блокирующая очередь []
        ExecutorService fixedPool = Executors.newFixedThreadPool(3);

        // передать задачу Runnable типа в очередь
        fixedPool.execute(() -> {
            System.out.println("Инструкции задачи №1 " +
                    Thread.currentThread().getName());
        });
        fixedPool.execute(() -> {
            System.out.println("Инструкции задачи №2 " +
                    Thread.currentThread().getName());
        });
        fixedPool.execute(() -> {
            System.out.println("Инструкции задачи №3 " +
                    Thread.currentThread().getName());
        });

        fixedPool.execute(() -> {
            System.out.println("Инструкции задачи №4 " +
                    Thread.currentThread().getName());
        });

        // fixedPool.shutdown();
        // завершает текущие задачи, но не принимает новые
        // к пулу нельзя обратиться повторно

        /*fixedPool.execute(() -> { java.util.concurrent.RejectedExecutionException
            System.out.println("Инструкции задачи №4 "+
                    Thread.currentThread().getName());
        });*/

        List<Runnable> runnables = fixedPool.shutdownNow();
        System.out.println(runnables.size());
        // прерывает выполнение текущих задач
        // не принимает новые задачи
        // возвращает оставшиеся в очереди задачи

        // какие задачи лучше не передавать в пул потоков???
        // задачи, связанные с ожиданием данных, например от пользователя
        // задачи с бесконечными циклами while(true)
        // задачи, которые заставляют потоки ждать друг друга (например, wait и notify)

        // [(t1), (t2), t3] утечка потоков из пула
        // t1 - while(true)
        // t2 - while(true)

        // [(t1), (t2), t3] утечка потоков из пула
        // t1 - exception
        // t2 - exception

        // изначальное количество потоков в пуле
        // Runtime().getRuntime().availableProcessors() + 1

        // изначальное количество потоков в пуле, если задачи, связанны с ожиданием данных
        // 2 * Runtime().getRuntime().availableProcessors() + 1


        AppPool appPool = new AppPool(1, 4, 4, TimeUnit.MINUTES, new ArrayBlockingQueue<>(20));
        // передать задачу в очередь
        appPool.execute(new AppTask("Task #1", "https://random-word-api.herokuapp.com/word"));
        appPool.execute(new AppTask("Task #2", "https://ran-word-api.herokuap/word"));
        appPool.execute(new AppTask("Task #3", "random-word-api.herokuap.com/word"));
        // и тд
        appPool.shutdown();


        ScheduledExecutorService pool01 = Executors.newScheduledThreadPool(3);
        pool01.scheduleAtFixedRate(() -> { // задача - экземпляр типа Runnable
                    try {
                        Thread.sleep(180_000); // Время выполнения - 3 минуты
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Scheduled Task #1");
                },
                0, // первоначальное время ожидания
                2, /* через 2 */ TimeUnit.MINUTES /* минуты после начала выполнения задачи она снова должна быть запущена */);
        // время реального запуска зависит от наличия свободных в пуле потоков
        // если время выполнения больше времени следующего запуска, очередь задач рано или поздно переполнится

        ScheduledExecutorService pool02 = Executors.newSingleThreadScheduledExecutor();
        pool02.scheduleWithFixedDelay(() -> { // задача - экземпляр типа Runnable
                    try {
                        Thread.sleep(120_000); // Время выполнения - 2 минуты
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Scheduled Task #2");
                },
                0, // первоначальное время ожидания
                1 /* через одну */, TimeUnit.MINUTES /* минуту после завершения выполнения задачи она снова должна быть запущена */);
        // время реального запуска зависит от наличия свободных в пуле потоков

        // можно прекратить выполнение задач shutdown методами
        // pool01.shutdown();
        // pool02.shutdown();

    }
}
