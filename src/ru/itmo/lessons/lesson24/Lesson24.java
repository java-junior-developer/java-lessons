package ru.itmo.lessons.lesson24;

import java.io.*;

public class Lesson24 {
    public static void main(String[] args) {
        final String filename = "company.bin";

        Company company01 = new Company("#1 Company", manager -> manager.getNumberOfEmployees() > 2);
        Lesson24.writeToFile(filename, company01);

        Company fromFile01 = Lesson24.readFromFile(filename);
        fromFile01.addManager(new Manager("Tom", 30_000, 10));

    }

    public static <T> void writeToFile(String filename, T object){
        // открытие ресурса FileOutputStream для записи байтов в файл filename
        // открытие ресурса ObjectOutputStream для преобразования объекта company в байты

        // objectOutput.writeObject(company):
        // 1. объект company преобразован в байты
        // 2. у FileOutputStream вызывается метод write,
        // байты, полученные в п.1 записываются в файл

        // ObjectOutputStream хранит ссылку на FileOutputStream,
        // поэтому способен вызвать его метод write и передать в него байты

        // закрытие ресурсов, открытых в () блока try:
        // objectOutput.close()
        // fileOutput.close()

        try (FileOutputStream fileOutput = new FileOutputStream(filename);
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {

            objectOutput.writeObject(object);

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        }
    }

    public static <T> T readFromFile(String filename){
        T fromFile = null;
        // открытие ресурса FileInputStream для чтения байтов из файла filename
        // открытие ресурса ObjectInputStream для преобразования байтов в объект (Company)

        // objectInput.readObject():
        // 1. у FileInputStream вызывается метод read,
        // который читает байты в программу
        // 2. ObjectInputStream преобразует полученные в п.1 байты в объект (Object)

        // ObjectInputStream хранит ссылку на FileInputStream,
        // поэтому способен вызвать его метод read и использовать прочитанные из файла байты

        // закрытие ресурсов, открытых в () блока try:
        // objectInput.close()
        // fileInput.close()
        try (FileInputStream fileInput = new FileInputStream(filename);
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)){

            fromFile = (T) objectInput.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        } catch (ClassNotFoundException e) { // когда байты преобразуются в объект типа (Object)
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        }
        return fromFile;
    }
}
