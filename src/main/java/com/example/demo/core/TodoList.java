package com.example.demo.core;

import java.lang.Iterable;

public interface TodoList {
    TodoList add(Todo todo);
    TodoList remove(long id);
    boolean exists(long id);
    Iterable<Todo> getTodos();
    int size();
    boolean isEmpty();
}
