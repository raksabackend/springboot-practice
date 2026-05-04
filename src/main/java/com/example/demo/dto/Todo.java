package com.example.demo.dto;

import lombok.Data;

@Data
public class Todo {

    private Long id;
    private String title;
    private boolean completed;

}
