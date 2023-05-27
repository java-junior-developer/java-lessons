package ru.itmo.lessons.lesson29.collections;

import ru.itmo.lessons.lesson25.common.Message;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Application extends Thread{

    public static void main(String[] args) {

        // первые потокобезопасные синхронизированные (synchronized) структуры данных:
        // Vector, HashTable, Stack

        // Однопоточные коллекции и мапы:
        ArrayList<String> stringArrayList = new ArrayList<>();
        HashSet<String> stringHashSet = new HashSet<>();
        Map<String, Integer> stringIntegerMap = new HashMap<>();

        // Ссылки на их синхронизированные (synchronized) потокобезопасные варианты:
        List<String> list = Collections.synchronizedList(stringArrayList);
        Set<String> set = Collections.synchronizedSet(stringHashSet);
        Map<String, Integer> map = Collections.synchronizedMap(stringIntegerMap);
        // list, set и map синхронизированы, при обращении к ним, поток захватывает их мониторы


        LinkedBlockingQueue<String> strings = new LinkedBlockingQueue<>();


        // при создании экземпляра необходимо указать максимальное количество элементов
        // конструктор public ArrayBlockingQueue(int capacity, boolean fair)
        // позволяет установить fair - флаг справедливости
        ArrayBlockingQueue<Message> messages = new ArrayBlockingQueue<>(10, true);

        new Thread(new WriteTask(messages)).start();
        new Thread(new WriteTask(messages)).start();
        new Thread(new WriteTask(messages)).start();
        new Thread(new ReadTask(messages)).start();


        // блокирующая очередь DelayQueue:
        // 1. класс, экземпляры которого помещаются в очередь
        // должен имплементировать интерфейс Delayed
        // 2. take блокирует поток, если данных в очереди нет
        // или если элемент нельзя извлечь из очереди
        DelayQueue<Task> tasks = new DelayQueue<>();
        // метод put вызывает метод compareTo объекта task,
        // чтобы разместить элементы в отсортированном порядке
        tasks.put(new Task(()->{
            System.out.println("old task");
        }, LocalDateTime.now().minusDays(1)));

        tasks.put(new Task(()->{
            System.out.println("future task");
        }, LocalDateTime.now().plusMinutes(3)));

        tasks.put(new Task(()->{
            System.out.println("now task");
        }, LocalDateTime.now().plusSeconds(20)));

        while (true) {
            try { // метод take вызывает метод getDelay объекта Task,
                // и если метод вернет положительное число,
                // то поток (в данном случае main) блокируется
                Runnable runnable = tasks.take().getAction();
                new Thread(runnable).start();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}