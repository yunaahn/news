package com.newsfeed.demo.controller;

import com.newsfeed.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name = "구독 API", description = "학교페이지 구독, 취소")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Operation(summary = "학교 구독", description = "유저가 학교 페이지구독 설정")
    @PostMapping("/{userId}/subscribe/{schoolId}")
    public ResponseEntity<Long> subscribeToSchool(@PathVariable Long userId, @PathVariable Long schoolId) {
        Long user = userService.subscribeToSchool(userId, schoolId);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @Operation(summary = "학교 구독 취소", description = "유저가 학교페이지 구독 취소")
    @DeleteMapping("/{userId}/unsubscribe/{schoolId}")
    public ResponseEntity<Long> unsubscribeFromSchool(@PathVariable Long userId, @PathVariable Long schoolId) {
        userService.unsubscribeFromSchool(userId, schoolId);
        return ResponseEntity.noContent().build();
    }
}
