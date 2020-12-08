package com.example.demo.core;

import com.example.demo.core.TodoList;
import com.example.demo.core.TodoListImpl;
import com.example.demo.core.Todo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TodoListTests {
    TodoList createFullTodoList() {
        return new TodoListImpl()
            .add(new Todo(1, "Lorem ipsum"))
            .add(new Todo(2, "Add more features"))
            .add(new Todo(3, "Create a roadmap"));
    }

    @Test
    void mustBeEmpty() {
        TodoList todoList = new TodoListImpl();
        assertTrue(todoList.isEmpty());
    }

    @Test
    void mustAddTodos() {
        TodoList todoList = createFullTodoList();

        assertEquals(3, todoList.size());
    }

    @Test
    void mustDeleteTodos() {
        TodoList todoList = createFullTodoList()
            .remove(1);

        assertEquals(2, todoList.size());
    }

    @Test
    void mustIterateOverTodos() {
        TodoList todoList = createFullTodoList();
        StringBuilder builder = new StringBuilder();

        for (Todo t : todoList.getTodos()) {
            builder.append(t.getTitle());
            builder.append("\n");
        }

        assertEquals(
            "Lorem ipsum\nAdd more features\nCreate a roadmap\n",
            builder.toString()
        );
    }
}
