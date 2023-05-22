package ru.itmo.lessons.lesson27;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class JoinThreads {
    public static void main(String[] args) {
        ArrayList<String> wishList = new ArrayList<>();
        ArrayList<String> prisesList = new ArrayList<>();

        class PredictionContainer {
            private String value;

            public PredictionContainer(String defaultValue) {
                this.value = defaultValue;
            }

            public void changeValue(String newValue) {
                this.value = newValue;
            }

            public String getValue(){
                return value;
            }
        }

        PredictionContainer predictionContainer = new PredictionContainer("not found");

        // использование join методов

        Thread wishListThread = new Thread(() -> { // завершение потока зависит от пользователя
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Write your wish");
                String fromUser = scanner.nextLine();
                if (fromUser.equals("stop")) break;
                wishList.add(fromUser.toUpperCase());
            }
        }, "Wish List Thread");

        Thread predictionThread = new Thread(() -> { // завершение потока зависит от
                                                     // ответа сервера и наличия ошибок
            URI uri = null;
            try {
                uri = new URI("https://random-word-api.herokuapp.com/word");
            } catch (URISyntaxException e) {
                throw new RuntimeException("URI Error");
            }

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    //.timeout(Duration.of(15, SECONDS))
                    .GET()
                    .build();

            try {
                HttpResponse<String> response = HttpClient.newHttpClient()
                        .send(request, HttpResponse.BodyHandlers.ofString());
                predictionContainer.changeValue(response.body().toUpperCase());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException("Request Error");
            }
        }, "Prediction Thread");

        Thread randomPrisesThread = new Thread(() -> { // зависит от числа, сгенерированного Math.random()
            int numberOfAttempts = (int) (Math.random() * 5);
            ArrayList<String> items = new ArrayList<>(Arrays.asList("book", "pen", "laptop", "book", "toy", "watch"));
            for (int i = 1; i <= numberOfAttempts; i++) {
                String prise = items.remove((int) (Math.random() * items.size()));
                prisesList.add(prise);
            }
        }, "Random Prises Thread");

        // wishListThread.setDaemon(true);

        wishListThread.start();
        predictionThread.start();
        randomPrisesThread.start();


        try {
            wishListThread.join(10_000);
            predictionThread.join();
            randomPrisesThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread: " + Thread.currentThread().getName());
        System.out.println("1. WishList:");
        wishList.forEach(System.out::println);

        System.out.println("2. Prediction: " + predictionContainer.getValue());

        System.out.println("3. PrisesList:");
        prisesList.forEach(System.out::println);

    }
}
