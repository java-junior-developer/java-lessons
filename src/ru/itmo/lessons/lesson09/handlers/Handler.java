package ru.itmo.lessons.lesson09.handlers;

abstract public class Handler {
    private String fileName;
    // другие свойства и методы


    public Handler(String fileName) {
        this.fileName = fileName;
    }

    abstract public void read();
    abstract public void write();

    public static Handler getInstance(String fileName){
        Handler handler = null;
        if (fileName.endsWith(".json")) {
            handler = new JsonHandler(fileName);
        } else {
            handler = new TxtHandler(fileName);
        }
        return handler;
    }
}



