package com.xiaoze.controller;

import com.xiaoze.service.IntroduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/introduces")
public class IntroduceController {
    @Autowired
    private IntroduceService service;


}
