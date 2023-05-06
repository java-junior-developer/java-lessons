package ru.itmo.lessons.lesson22.decorator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AppFileWriter implements AppLogger{ // основной функционал
    private String filename;

    public AppFileWriter(String filename) {
        this.filename = filename;
    }

    @Override
    public void log(String message) {
        try {
            Files.writeString(Paths.get(filename), message, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Данные не были записаны");
            e.printStackTrace();
        }
    }
}
