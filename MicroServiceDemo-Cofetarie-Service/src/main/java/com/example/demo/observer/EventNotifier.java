package com.example.demo.observer;

import java.util.ArrayList;
import java.util.List;

public class EventNotifier {
    private final List<Observer> observers = new ArrayList<>();

    public void register(Observer o) {
        observers.add(o);
    }

    public void unregister(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }
}
