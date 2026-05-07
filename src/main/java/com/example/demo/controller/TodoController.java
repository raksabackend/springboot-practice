package com.example.demo.controller;

import com.example.demo.dto.Todo;
import com.example.demo.dto.UpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public Todo getTodoById(@PathVariable("id") Long id) {
        return todos.stream().filter(c -> Objects.equals(c.getId(), id)).map(m -> new Todo(m.getId(), m.getTitle(), m.isCompleted())).findFirst().orElse(null);
    }

    @DeleteMapping("/{id}")
    public Todo deleteById(@PathVariable("id") Long id) {

        Todo todoToDelete = todos.stream()
                .filter(todo -> id.equals(todo.getId()))
                .findFirst()
                .orElse(null);

        if (todoToDelete!=null) {
            todos.remove(todoToDelete);
        }

        return todoToDelete;
    }

    @PatchMapping("/{id}")
    public Todo updateById(
            @PathVariable("id") Long id,
            @RequestBody UpdateDto updateTodo
    ) {

        Todo todoToUpdate = todos.stream()
                .filter(todo -> id.equals(todo.getId()))
                .findFirst()
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Todo Not Found"
                ));

        if (todoToUpdate != null) {
            todoToUpdate.setTitle(updateTodo.getTitle());
            todoToUpdate.setCompleted(updateTodo.isCompleted());
        }

        return todoToUpdate;
    }

}

