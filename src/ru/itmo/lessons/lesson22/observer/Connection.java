package ru.itmo.lessons.lesson22.observer;

import java.util.ArrayList;

public class Connection {
    private ArrayList<Listener> listeners = new ArrayList<>();
    private Status status = Status.CLOSE;

    public void addListener(Listener listener){
        listeners.add(listener);
    }

    public void changeStatus(Status status) {
        this.status = status;
        listeners.forEach(listener -> listener.execute(this));
    }

    public enum Status {
        ACTIVE, CLOSE, CONNECTED, WAITING
    }

}
