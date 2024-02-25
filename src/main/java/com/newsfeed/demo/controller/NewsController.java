package com.newsfeed.demo.controller;

import com.newsfeed.demo.domain.News;
import com.newsfeed.demo.Repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    // 모든 뉴스 조회
    @GetMapping
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    // 뉴스 상세 정보 조회
    @GetMapping("/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable Long id) {
        News news = newsRepository.findById(id).orElse(null);
        if (news == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(news);
        }
    }

    // 뉴스 추가
    @PostMapping
    public ResponseEntity<News> addNews(@RequestBody News news) {
        News savedNews = newsRepository.save(news);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNews);
    }

    // 뉴스 수정
    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews(@PathVariable Long id, @RequestBody News news) {
        News existingNews = newsRepository.findById(id).orElse(null);
        if (existingNews == null) {
            return ResponseEntity.notFound().build();
        } else {
            news.setId(id);
            News updatedNews = newsRepository.save(news);
            return ResponseEntity.ok(updatedNews);
        }
    }

    // 뉴스 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable Long id) {
        News existingNews = newsRepository.findById(id).orElse(null);
        if (existingNews == null) {
            return ResponseEntity.notFound().build();
        } else {
            newsRepository.delete(existingNews);
            return ResponseEntity.noContent().build();
        }
    }
}
