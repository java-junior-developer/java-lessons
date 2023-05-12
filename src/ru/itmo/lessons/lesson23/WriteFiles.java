package ru.itmo.lessons.lesson23;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteFiles {
    public static void writeWithFiles(String filename, String data) throws IOException {
        // запись строки
        Files.writeString(Paths.get(filename), data, StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        /* запись массива байт
        byte[] bytesData = data.getBytes();
        Files.write(Paths.get(filename), bytesData, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        */
    }

    public static void writeWithBuffer(String filename, String data) throws IOException {
        // запись массива байт
        byte[] bytesData = data.getBytes();
        try (FileOutputStream fileOutput = new FileOutputStream(filename, true);
             BufferedOutputStream buffer = new BufferedOutputStream(fileOutput, 512)) {
            buffer.write(bytesData);  // -> fileOutput.write(накопленные байты);
            // можно записывать в цикле
        }

        // запись строки
        try (Writer writer = new FileWriter(filename, true);
             BufferedWriter buffer = new BufferedWriter(writer, 512)) {
            buffer.write(data);  // -> writer.write(накопленные данные);
            // можно записывать в цикле
        }

        // запись строки, экземпляры Writer и BufferedWriter создаются в методе newBufferedWriter
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(data, 0, data.length());
            // можно записывать в цикле
        }
    }

    public static void writeToDataStream(String filename, String data) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filename, true);
             DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos))) {
            outStream.writeUTF(data);
            outStream.writeBoolean(true);
        }
    }


    public static void writeToChannel(String filename, String data) throws IOException {
        try (RandomAccessFile writer = new RandomAccessFile(filename, "rw");
             FileChannel channel = writer.getChannel()) {
            byte[] bytesData = data.getBytes(StandardCharsets.UTF_8);
            ByteBuffer buff = ByteBuffer.wrap(bytesData);
            channel.write(buff);
        }
    }

    public static void writeToRandomAccess(String filename) throws IOException {
        long offset = 10;
        int data = 1000;
        try (RandomAccessFile writer = new RandomAccessFile(filename, "rw")) {
            writer.seek(offset);
            writer.writeInt(data);
            writer.writeUTF(String.valueOf(data));
        }
    }
}
