package ru.itmo.lessons.lesson27.task;

import ru.itmo.lessons.lesson25.common.Message;
import ru.itmo.lessons.lesson25.common.ReadWrite;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArraySet;

public class ServerWithThreads {
    private int port;
    private CopyOnWriteArraySet<ReadWrite> connections;

    public ServerWithThreads(int port) {
        this.port = port;
        connections = new CopyOnWriteArraySet<>();
    }

    public void startServer(){
        try (ServerSocket serverSocket = new ServerSocket(port)){
            while (true) {
                Socket socket = null;
                try {
                    socket = serverSocket.accept();
                    ReadWrite connection = new ReadWrite(socket);

                    connections.add(connection);
                    /*ThreadForConnection thread = new ThreadForConnection(connection, connections);
                    thread.start();*/

                } catch (IOException e) {
                    System.out.println("Не удалось установить соединение с клиентом");
                    if (socket != null) socket.close();
                }
            }

        } catch (IOException e) {

        }
    }
}
