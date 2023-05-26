package ru.itmo.lessons.lesson29.executors;

import ru.itmo.lessons.lesson25.common.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Predicate;

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
            System.out.println("Инструкции задачи №2 "+
                    Thread.currentThread().getName());
        });
        fixedPool.execute(() -> {
            System.out.println("Инструкции задачи №3 "+
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











    }
}
