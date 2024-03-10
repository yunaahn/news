package com.newsfeed.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class AdminController {

    private final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
    @GetMapping("/admin")
    public String adminP() {

        return "admin Controller";
    }
}
