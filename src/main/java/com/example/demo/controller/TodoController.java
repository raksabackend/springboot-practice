package com.example.demo.controller;

import com.example.demo.dto.Todo;
import com.example.demo.dto.UpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        todos.add(todo);
        return ResponseEntity.ok().body(todo);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos() {
        return ResponseEntity.ok().body(todos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") Long id) {
        Todo todo = todos.stream().filter(c -> Objects.equals(c.getId(), id)).map(m -> new Todo(m.getId(), m.getTitle(), m.isCompleted())).findFirst().orElse(null);
        return ResponseEntity.ok().body(todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Todo> deleteById(@PathVariable("id") Long id) {

        Todo todoToDelete = todos.stream()
                .filter(todo -> id.equals(todo.getId()))
                .findFirst()
                .orElse(null);

        if (todoToDelete!=null) {
            todos.remove(todoToDelete);
        }

        return ResponseEntity.ok().body(todoToDelete);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Todo> updateById(
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

        return ResponseEntity.ok().body(todoToUpdate);
    }

}

