package com.newsfeed.demo.controller;

import com.newsfeed.demo.domain.School;
import com.newsfeed.demo.Repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    // 모든 학교 조회
    @GetMapping
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    // 학교 상세 정보 조회
    @GetMapping("/{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable Long id) {
        School school = schoolRepository.findById(id).orElse(null);
        if (school == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(school);
        }
    }

    // 학교 추가
    @PostMapping
    public ResponseEntity<School> addSchool(@RequestBody School school) {
        School savedSchool = schoolRepository.save(school);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSchool);
    }

    // 학교 수정
    @PutMapping("/{id}")
    public ResponseEntity<School> updateSchool(@PathVariable Long id, @RequestBody School school) {
        School existingSchool = schoolRepository.findById(id).orElse(null);
        if (existingSchool == null) {
            return ResponseEntity.notFound().build();
        } else {
            school.setId(id);
            School updatedSchool = schoolRepository.save(school);
            return ResponseEntity.ok(updatedSchool);
        }
    }

    // 학교 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable Long id) {
        School existingSchool = schoolRepository.findById(id).orElse(null);
        if (existingSchool == null) {
            return ResponseEntity.notFound().build();
        } else {
            schoolRepository.delete(existingSchool);
            return ResponseEntity.noContent().build();
        }
    }
}
