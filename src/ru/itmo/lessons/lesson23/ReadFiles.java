package ru.itmo.lessons.lesson23;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


public class ReadFiles {

    public static void readWithFilesToList(String filename) throws IOException {
        List<String> stringList = Files.readAllLines(Path.of(filename));
    }

    public static void readWithFilesToStream(String filename) throws IOException {
        // ресурс закрывается, когда закрывается Stream
        try (Stream<String> lines = Files.lines(Path.of(filename))) {

        }
    }


    public static void readWithBuffer(String filename) throws IOException {
        // чтение в массив байт
        try (FileInputStream fileInputStream = new FileInputStream(filename);
             BufferedInputStream buffered = new BufferedInputStream(fileInputStream, 1024);
             ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        ) {

            byte[] buf = new byte[512];
            int data;

            while ((data = buffered.read(buf)) != -1) {
                byteArray.write(buf, 0, data);
            }

            String text = byteArray.toString();
        }


        // чтение строки, экземпляры Reader и BufferedReader создаются в методе newBufferedReader
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8)) {
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        }
    }

    public static void readFromChannel(String filename) throws IOException {
        try (RandomAccessFile reader = new RandomAccessFile(filename, "r");
             FileChannel channel = reader.getChannel();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            int bufferSize = Math.min(512, (int) channel.size());

            ByteBuffer buffer = ByteBuffer.allocate(bufferSize);

            while (channel.read(buffer) > 0) {
                out.write(buffer.array(), 0, buffer.position());
                buffer.clear();
            }

            String fromFile = out.toString(StandardCharsets.UTF_8);
        }
    }

    public static void readWithScanner(String filename) throws IOException {
        try (Scanner scanner = new Scanner(new File(filename), StandardCharsets.UTF_8)) {
            String line = null;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
            }

            if (scanner.ioException() != null) {
                throw scanner.ioException();
            }
        }
    }

    public static void readFromDataStream(String filename) throws IOException{
        try (FileInputStream fis = new FileInputStream(filename);
             DataInputStream reader = new DataInputStream(fis)) {
            String strFromFile = reader.readUTF();
            System.out.println(strFromFile);
            boolean boolFromFile = reader.readBoolean();
            System.out.println(boolFromFile);
        }
    }

    public static void readFromRandomAccess(String filename) throws IOException {
        long offset = 10;
        try (RandomAccessFile reader = new RandomAccessFile(filename, "r")) {
            reader.seek(offset);
            int intFromFile = reader.readInt();
            System.out.println(intFromFile);
            String strFromFile = reader.readUTF();
            System.out.println(strFromFile);
        }
    }

}