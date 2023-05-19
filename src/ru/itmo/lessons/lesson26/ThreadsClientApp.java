package ru.itmo.lessons.lesson26;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ThreadsClientApp {
    private InetSocketAddress address;
    private OutputStream output;
    private InputStream input;
    private Socket socket;

    public ThreadsClientApp(InetSocketAddress address) {
        this.address = address;
        socket = new Socket();
    }

    public void start() {
        try {
            socket.connect(address);
            output = socket.getOutputStream();
            input = socket.getInputStream();
            new Receiver().start();
            new Sender().start();
        } catch (IOException e) {
            System.out.println("Удаленный сервер не отвечает. Проверьте адрес");
        }
    }

    private class Sender extends Thread {
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Введите сообщение");
                String text = scanner.nextLine();
                try {
                    output.write(text.getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    System.out.println("Удаленный сервер перестал отвечать");
                    try {
                        input.close();
                        output.close();
                        socket.close();
                    } catch (Exception ex) {
                        System.out.println("Ошибка закрытия ресурса");
                    }
                    return;
                }
            }
        }
    }

    private class Receiver extends Thread {
        @Override
        public void run() {
            byte[] bytes = new byte[1024];
            while (true) {
                try {
                    int read = input.read(bytes);
                    String text = new String(bytes, 0, read);
                    System.out.println(text);
                } catch (IOException e) {
                    System.out.println("Удаленный сервер перестал отвечать");
                    try {
                        input.close();
                        output.close();
                        socket.close();
                    } catch (Exception ex) {
                        System.out.println("Ошибка закрытия ресурса");
                    }
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadsClientApp(new InetSocketAddress("127.0.0.1", 2222)).start();
    }
}
