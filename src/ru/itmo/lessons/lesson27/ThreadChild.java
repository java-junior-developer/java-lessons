package ru.itmo.lessons.lesson27;

// имя класса зависит от хранимой информации и выполняемых задач
// extends Thread - экземпляры ThreadChild - потоки
public class ThreadChild extends Thread {
    // любые необходимые свойства
    // любые необходимые конструкторы
    // любые необходимые методы

    @Override
    public void run() {
        // инструкции будут выполнятся в отдельном потоке
        // можно обращаться к свойствам,
        // вызвать необходимые методы
    }
}
