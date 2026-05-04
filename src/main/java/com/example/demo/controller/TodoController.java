package com.example.demo.controller;

import com.example.demo.dto.Todo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

     private List<Todo> todos = new ArrayList<>();




}