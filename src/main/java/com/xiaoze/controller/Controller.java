package com.xiaoze.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class Controller {
    @GetMapping
    public String get(){
        System.out.println("running");
        return "running";
    }
}
