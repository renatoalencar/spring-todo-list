package com.example.demo.core;

public class Todo {
    private final long id;
    private final String title;

    public Todo(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
