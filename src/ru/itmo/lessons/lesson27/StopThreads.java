package ru.itmo.lessons.lesson27;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.*;

public class StopThreads {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            URI uri = null;
            try {
                uri = new URI("https://random-word-api.herokuapp.com/word");
            } catch (URISyntaxException e) {
                throw new RuntimeException("URI Error");
            }

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();
            HttpClient client = HttpClient.newHttpClient();

            Path pathToWrite = Path.of("thread.txt");
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    HttpResponse<String> response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());
                    String data = response.body();
                    System.out.println(data);
                    Files.writeString(pathToWrite, data, APPEND, CREATE);
                    Thread.sleep(10_000);
                } catch (IOException | InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread.start();


        Scanner scanner = new Scanner(System.in);
        System.out.println("stop http thread");
        scanner.nextLine();
        thread.interrupt();

    }
}
