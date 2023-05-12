package ru.itmo.lessons.lesson23;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Lesson23 {
    public static void main(String[] args) {
        Resource resource = null;
        try {
            resource = new Resource();
            // использование ресурса
        } catch (Exception e) {
            // обработка возникающих исключений
        }
        finally {
            if (resource != null) resource.close();
        }

        // в java 7 появился try with resources
        try (Resource authoclosableResource = new Resource()) {
            // использование ресурса
        } catch (Exception e) {
            // обработка возникающих исключений
        }

        // string.replaceAll("\\pP", " ")

        // кодировка
        // Charset charset = Charset.forName("US-ASCII");
        // Charset charset = StandardCharsets.US_ASCII;

        // путь файловой системы
        String name = "src/tasks"; // имя файла или директории

        // IO пакет ( File)
        File file = new File(name); // не обязан существовать
        // содержит методы проверки, создания, удаления и т.д
        if (file.isDirectory()) {
            System.out.println(file.getAbsolutePath());
            File[] files = file.listFiles((dir, filename) -> filename.endsWith(".java")); // boolean accept(File dir, String name);
            for (File fromDir : files) {
                System.out.println(fromDir.getName());
                System.out.println(fromDir.canExecute());
                System.out.println(fromDir.canWrite());
            }
        }
        // nio пакет (Path)
        Path path = Paths.get(name);
        // Path содержит имя файла и список каталогов, определяющих путь к файлу и соответствующие методы

        // класс Files содержит методы проверки, создания, удаления и т.д

        File f = path.toFile();
        Path p = f.toPath();

    }
}
