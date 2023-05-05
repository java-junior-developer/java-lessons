package ru.itmo.lessons.lesson22;

import java.util.ArrayList;

public class Connection {
    private ArrayList<Listener> listeners = new ArrayList<>();
    private String status;

    public void addListener(Listener listener){
        listeners.add(listener);
    }

    public void changeStatus(String status) {
        this.status = status;
        listeners.forEach(listener -> listener.execute(this));
    }

}
