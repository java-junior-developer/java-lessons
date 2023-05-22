package ru.itmo.lessons.lesson27;

public class Base {
    public static void main(String[] args) throws InterruptedException {

        // создание экземпляров и запуск потоков
        ThreadChild thread01 = new ThreadChild(); // поток создан

        System.out.println(thread01.getState()); // статус потока
        thread01.setPriority(8); // установлен приоритет
        thread01.setName("Thread #1"); // установлено новое имя потока

        thread01.start(); // передача потока в очередь на выполнение
        // thread01.run(); // при вызове инструкции будут выполнены, но не в отдельном потоке

        System.out.println(thread01.getState()); // статус потока

        thread01.join(); // ожидание завершения выполнений инструкций
        System.out.println(thread01.getState()); // статус потока

        ThreadTask task = new ThreadTask(); // создан экземпляр, хранящий инструкции потока
        // task.run(); // инструкции будут выполнены, но не в отдельном потоке

        Thread thread02 = new Thread(task); // поток создан

        System.out.println(thread02.getPriority()); // узнали приоритет потока
        System.out.println(thread02.getName()); // узнали имя потока

        thread02.start(); // передача потока в очередь на выполнение
        // thread02.run(); // инструкции будут выполнены, но не в отдельном потоке


        Runnable lambdaTask = () -> { // создан экземпляр, хранящий инструкции потока
            // инструкции будут выполнятся в отдельном потоке,
            // если lambdaTask будет передан в конструктор Thread
        };
        // lambdaTask.run(); // инструкции будут выполнены, но не в отдельном потоке

        Thread thread03 = new Thread(lambdaTask); // создан поток

        System.out.println(thread03.getThreadGroup().getName()); // узнали имя группы, которой принадлежит поток

        thread03.start(); // передача потока в очередь на выполнение
        // thread03.run(); // инструкции будут выполнены, но не в отдельном потоке



        // группы потоков

        // отдельные группы
        ThreadGroup group00 = new ThreadGroup("Group 00");
        // иерархия групп
        ThreadGroup group01 = new ThreadGroup("Group 01"); // входит в состав group02
        ThreadGroup group02 = new ThreadGroup(group01, "Group 02"); // входит в состав group03
        ThreadGroup group03 = new ThreadGroup(group02, "Group 03"); // содержит group02, которая содержит group01

        Runnable runnableTask = () -> {};

        Thread threadInGroup = new Thread(group00, runnableTask, "threadInGroup");

        System.out.println(threadInGroup.getThreadGroup().getName()); // имя группы
        System.out.println(threadInGroup.getThreadGroup().getMaxPriority()); // максимальный приоритет группы

        threadInGroup.start();

    }
}
