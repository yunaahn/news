// UserController.java
package com.newsfeed.demo.controller;

import com.newsfeed.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "유저 구독 API", description = "학교페이지 구독, 취소")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "학교 구독", description = "유저가 학교 페이지 구독 설정")
    @PostMapping("/{Id}/subscribe/{schoolId}")
    public ResponseEntity<Long> subscribeToSchool(@PathVariable Long Id, @PathVariable Long schoolId) {
        Long subscribedSchoolId = userService.subscribeToSchool(Id, schoolId);
        // 여기서 새로운 구독 ID를 반환하거나 적절한 처리를 수행합니다.
        return ResponseEntity.status(HttpStatus.CREATED).body(subscribedSchoolId);
    }

    @Operation(summary = "학교 구독 취소", description = "유저가 학교 페이지 구독 취소")
    @DeleteMapping("/{Id}/unsubscribe/{schoolId}")
    public ResponseEntity<Void> unsubscribeFromSchool(@PathVariable Long Id, @PathVariable Long schoolId) {
        boolean unsubscribed = userService.unsubscribeFromSchool(Id, schoolId);
        if (unsubscribed) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
