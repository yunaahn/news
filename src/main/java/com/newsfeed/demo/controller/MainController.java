package com.newsfeed.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class MainController {

    private final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
    @GetMapping("/")
    public String mainP() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName(); //현재 세션 사용자 아이디
        return "Main Controller : " + name;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "health";
    }
}
