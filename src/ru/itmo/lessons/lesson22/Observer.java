package ru.itmo.lessons.lesson22;

public class Observer {
    public static void main(String[] args) {
        Connection connection = new Connection();

        Listener log = c -> System.out.println("log");
        Listener message = c -> System.out.println("message");
        Listener ping = c -> System.out.println("ping");

        connection.addListener(log);
        connection.addListener(message);
        connection.addListener(ping);

        connection.changeStatus("new status");
    }
}
