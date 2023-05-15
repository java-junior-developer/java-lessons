package ru.itmo.lessons.lesson24;

import java.io.*;

public class Lesson24 {
    public static void main(String[] args) {
        final String filename = "company.bin";

        Company company01 = new Company("#1 Company", manager -> manager.getNumberOfEmployees() > 2);
        writeToFile(filename, company01);

        Company fromFile01 = readFromFile(filename);
        fromFile01.addManager(new Manager("Tom", 30_000, 10));

    }

    public static void writeToFile(String filename, Company company){
        try (FileOutputStream fileOutput = new FileOutputStream(filename);
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)){
            objectOutput.writeObject(company);

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        }
    }

    public static Company readFromFile(String filename){
        Company fromFile = null;
        try (FileInputStream fileInput = new FileInputStream(filename);
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)){
            fromFile = (Company) objectInput.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        }
        return fromFile;
    }
}
