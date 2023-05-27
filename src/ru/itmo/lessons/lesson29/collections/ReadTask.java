package ru.itmo.lessons.lesson29.collections;

import ru.itmo.lessons.lesson25.common.Message;

import java.util.concurrent.ArrayBlockingQueue;

// функционал потока потребителя
public class ReadTask implements Runnable{
    private ArrayBlockingQueue<Message> messages;

    public ReadTask(ArrayBlockingQueue<Message> messages) {
        this.messages = messages;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            // удаляет и возвращает ссылку на первый элемент из очереди
            // поток блокируется, если в очереди нет элементов
            // до их появления
            // вызов put и take заставляют обработать
            // InterruptedException - исключение времени компиляции

            try {
                Message message = messages.take(); // только метод take приостанавливает
                // работу потока до тех пор, пока в очереди не появятся элементы
                System.out.println("read " + message);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
