package com.newsfeed.demo.controller;

import com.newsfeed.demo.domain.School;
import com.newsfeed.demo.service.SchoolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "학교페이지API", description = "학교 페이지 생성 및 관리")
@RestController
@RequestMapping("/school")
public class SchoolController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @Operation(summary = "모든 학교정보 조회", description = "설명")
    @GetMapping
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @Operation(summary = "특정 학교정보 조회", description = "설명")
    @GetMapping("/{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable Long id) {
        return schoolService.getSchoolById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @Operation(summary = "학교 페이지 생성", description = "지역, 학교명으로 학교 페이지 생성")
    @PostMapping
    public ResponseEntity<School> addSchool(@RequestBody School school) {
        School savedSchool = schoolService.saveSchool(school);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSchool);
    }
    @Operation(summary = "학교 페이지 정보수정", description = "학교 페이지 정보 수정")
    @PutMapping("/{id}")
    public ResponseEntity<School> updateSchool(@PathVariable Long id, @RequestBody School school) {
        school.setId(id);
        School updatedSchool = schoolService.saveSchool(school);
        return ResponseEntity.ok(updatedSchool);
    }
    @Operation(summary = "학교 페이지 삭제", description = "학교 페이지 삭제")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable Long id) {
        schoolService.deleteSchool(id);
        return ResponseEntity.noContent().build();
    }
}
