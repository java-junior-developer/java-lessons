package ru.itmo.lessons.lesson29.executors;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ArrayBlockingQueue;

public class AppTask implements Runnable {
    private final String name;
    private final String uriValue;

    public AppTask(String name, String uriValue) {
        this.name = name;
        this.uriValue = uriValue;
    }

    public String getName() {
        return name;
    }

    private HttpRequest makeRequest() throws URISyntaxException {
        return HttpRequest.newBuilder()
                .uri(new URI(uriValue))
                .GET()
                .build();
    }

    @Override
    public void run() {
        try {
            HttpRequest request = makeRequest();
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body().toUpperCase());
        } catch (IOException | InterruptedException | URISyntaxException | IllegalArgumentException e) {
            throw new RuntimeException("Request Error");
        }
    }
}
