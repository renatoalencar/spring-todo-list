package com.example.demo.core;

import java.util.Map;
import java.util.HashMap;

public class TodoListImpl implements TodoList {
    private final Map<Long, Todo> todos = new HashMap<>();

    public TodoList add(Todo todo) {
        todos.put(Long.valueOf(todo.getId()), todo);

        return this;
    }

    public TodoList remove(long id) {
        todos.remove(Long.valueOf(id));

        return this;
    }

    public boolean exists(long id) {
        return todos.containsKey(Long.valueOf(id));
    }

    public Iterable<Todo> getTodos() {
        return todos.values();
    }

    public int size() {
        return todos.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
