package ru.itmo.lessons.lesson23;

// java.lang.AutoCloseable
public class Resource implements AutoCloseable{ // implements Closeable
    @Override
    public void close() /* throws Exception */ {
        System.out.println("Закрытие ресурсов");
    }

}
