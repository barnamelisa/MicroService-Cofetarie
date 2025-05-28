package com.example.demo.observer;

public class AuditLogger implements Observer {
    private static AuditLogger instance;

    private AuditLogger() {}

    public static synchronized AuditLogger getInstance() {
        if (instance == null) {
            instance = new AuditLogger();
        }
        return instance;
    }

    @Override
    public void update(String message) {
        System.out.println("[AUDIT] " + message);
    }
}
