package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.demo.core.Todo;
import com.example.demo.core.TodoList;
import com.example.demo.core.TodoListImpl;

@RestController
public class TodoListController {
    private final AtomicLong currentId = new AtomicLong();
    private final TodoList todos = new TodoListImpl();

    @GetMapping("/todos")
    public Iterable<Todo> todos() {
        return todos.getTodos();
    }

    @PostMapping("/todo")
    public Todo addTodo(@RequestParam String title) {
        Todo todo = new Todo(currentId.incrementAndGet(), title);

        todos.add(todo);

        return todo;
    }

    @DeleteMapping("/todo/{todoId}")
    public void removeTodo(@PathVariable long todoId) {
        if (!todos.exists(todoId)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Todo not found"
            );
        }

        todos.remove(todoId);
    }
}
