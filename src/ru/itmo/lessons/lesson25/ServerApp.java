package ru.itmo.lessons.lesson25;

import ru.itmo.lessons.lesson25.common.Message;
import ru.itmo.lessons.lesson25.common.ReadWrite;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class ServerApp {
    private int port;
    private Map<String, Task> tasksMap;

    // При создании сервера в конструктор передается номер порта (int),
    // по которому клиенты смогут подключаться к серверу.
    public ServerApp(int port) {
        this.port = port;
        tasksMap = new HashMap<>();
    }

    public void run(){
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Сервер запущен...");

            while (true) {
                Socket socket = serverSocket.accept(); // устанавливает соединение с клиентом
                try (ReadWrite readWrite = new ReadWrite(socket)){
                    sendResponse(readWrite, read(readWrite));
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

    private void sendResponse(ReadWrite readWrite, Message requestMessage) { // выполнение запрошенной задачи
        Message responseMessage;
        if (requestMessage == null || !tasksMap.containsKey(requestMessage.getText())) {
            responseMessage = new Message("Задача не может быть выполнена");
        } else {
            responseMessage = tasksMap.get(requestMessage.getText()).execute(this);
        }
        write(readWrite, responseMessage);
    }

    private void write(ReadWrite readWrite, Message message) {
        try {
            readWrite.writeMessage(message); // отправка сообщения клиенту
        } catch (IOException e) {
            System.out.println("Ошибка отправки сообщения");
        }
    }


    private Message read(ReadWrite readWrite){
        Message fromClient = null;
        try {
            fromClient = readWrite.readMessage(); // чтение сообщения от клиента
        } catch (IOException e) {
            System.out.println("Ошибка во время чтения");
        }
        return fromClient;
    }

    public void addTask(Task task) {
        tasksMap.put(task.getName(), task);
    }

    public Map<String, Task> getTasksMap(){
        return Collections.unmodifiableMap(tasksMap);
    }


    public static void main(String[] args) {
        Task help = new Task("/help", "список доступных запросов и их описание", serverApp -> {
            StringBuilder builder = new StringBuilder();
            for (Task task: serverApp.getTasksMap().values()) {
                builder.append(task.getName())
                        .append(" - ")
                        .append(task.getDescription())
                        .append("\n");
            }
            return new Message(builder.toString());
        });

        Task requests = new Task("/requests", "количество успешно обработанных запросов", serverApp -> {
            long numberOfRequests = serverApp.getTasksMap().values().stream()
                    .mapToLong(Task::getExecuted).sum();
            return new Message(String.valueOf(numberOfRequests));
        });

        Task popular = new Task("/popular", "название самого популярного запроса", serverApp -> {
            String taskName = serverApp.getTasksMap().values().stream()
                    .filter(task -> task.getExecuted() > 0)
                    .max(Comparator.comparing(Task::getExecuted))
                    .flatMap(task -> task.getName().describeConstable())
                    .orElse("нет выполненных запросов");
            return new Message(taskName);
        });

        ServerApp serverApp = new ServerApp(2222);

        serverApp.addTask(help);
        serverApp.addTask(requests);
        serverApp.addTask(popular);

        serverApp.run();
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
