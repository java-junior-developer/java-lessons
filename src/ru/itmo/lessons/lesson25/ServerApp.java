package ru.itmo.lessons.lesson25;

import ru.itmo.lessons.lesson25.common.Message;
import ru.itmo.lessons.lesson25.common.ReadWrite;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerApp {
    private int port;

    // При создании сервера в конструктор передается номер порта (int),
    // по которому клиенты смогут подключаться к серверу.
    public ServerApp(int port) {
        this.port = port;
    }

    public void run(){
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Сервер запущен...");

            while (true) {
                Socket socket = serverSocket.accept(); // 3.1. устанавливает соединение с клиентом
                try (ReadWrite readWrite = new ReadWrite(socket)){
                    read(readWrite);
                    write(readWrite);
                } /*catch (ClassCastException e) {
                    System.out.println("Класс Message не найден");
                }*/ catch (IOException e){
                    System.out.println("Ошибка во время создания объекта");
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка создания serverSocket, например, указанный порт занят");
            e.printStackTrace();
        }
    }

    private void write(ReadWrite readWrite) {
        Message answer = new Message("server"); // 3.3. формирует ответное сообщение (с произвольным текстом)
        try {
            readWrite.writeMessage(answer); // 3.4. отправляет сообщение клиенту
        } catch (IOException e) {
            System.out.println("Ошибка отправки сообщения");
        }
    }


    private void read(ReadWrite readWrite){
        Message fromClient = null; // 3.2. получает от клиента сообщение
        try {
            fromClient = readWrite.readMessage();
            String requestText = fromClient.getText();
            // обработка известных серверу запросов
        } catch (IOException e) {
            System.out.println("Ошибка во время чтения");
        }
        System.out.println(fromClient.getText());
    }




    public static void main(String[] args) {
        new ServerApp(2222).run();
        /*
        ServerSocket serverSocket = null; // позволит установить соединение
        // с клиентскими программами
        OutputStream output = null; // позволит отправлять данные
        InputStream input = null; // позволит получать данные


        try {
            serverSocket = new ServerSocket(2222); // привязка серверной программы к указанному порту.
            // ServerSocket слушает указанный порт...
            System.out.println("Сервер запущен");

            while (true) {
                Socket socket = serverSocket.accept(); // ...и устанавливает соединение при появлении клиента
                System.out.println("Новое подключение");

                System.out.println(socket.getLocalSocketAddress());
                System.out.println(socket.getRemoteSocketAddress());

                output = socket.getOutputStream(); // для отправки данных по socket соединению
                input = socket.getInputStream(); // для получения данных по socket соединению

                // ObjectInputStream objectInput = new ObjectInputStream(input); // десериализация
                // ObjectOutputStream objectOutput = new ObjectOutputStream(output); // сериализация

                // ожидание, когда в inputStream появятся данные
                System.out.println(input.read()); // чтение данных из inputStream
                output.write(2); // отправка данных в outputStream
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (input != null) input.close();
                if (output != null) output.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        */
    }
}
