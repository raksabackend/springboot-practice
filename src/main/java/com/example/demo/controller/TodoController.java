package com.example.demo.controller;

import com.example.demo.dto.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private List<Todo> todos = new ArrayList<>();

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        todos.add(todo);
        return todo;
    }

    @GetMapping
    public List<Todo> getTodos() {
        return todos;
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable("id") Integer id) {
        return todos.stream().filter(c -> Objects.equals(c.getId(), id)).map(m -> new Todo(m.getId(), m.getTitle(), m.isCompleted())).findFirst().orElse(null);
    }

}