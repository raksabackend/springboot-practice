package com.example.demo.controller;

import com.example.demo.dto.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{id}")
    public ResponseEntity<String> getUser (@PathVariable int id) {
        return ResponseEntity.ok("User " + id);
    }

    @PostMapping
    public ResponseEntity<UserRequest> createUser(@RequestBody UserRequest request) {
        return ResponseEntity.ok(request);
    }

}
