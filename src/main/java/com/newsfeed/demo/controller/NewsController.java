package com.newsfeed.demo.controller;

import com.newsfeed.demo.domain.News;
import com.newsfeed.demo.service.NewsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Tag(name = "뉴스피드 API", description = "뉴스피드 API")
@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @Operation(summary = "모든 뉴스피드 조회", description = "설명")
    @GetMapping
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }

    @Operation(summary = "특정 뉴스피드 조회", description = "유저가 구독하고 있는 특정 뉴스피드만 조회")
    @GetMapping("/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable Long id) {
        News news = newsService.getNewsById(id);
        return ResponseEntity.ok().body(news);
    }
    @Operation(summary = "뉴스피드 작성", description = "관리자가 뉴스피드를 작성")
    @PostMapping
    public ResponseEntity<News> addNews(@RequestBody News news) {
        News createdNews = newsService.addNews(news);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNews);
    }
    @Operation(summary = "뉴스피드 수정", description = "관리자가 뉴스피드 내용을 수정")
    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews(@PathVariable Long id, @RequestBody News news) {
        News updatedNews = newsService.updateNews(id, news);
        return ResponseEntity.ok().body(updatedNews);
    }
    @Operation(summary = "뉴스피드 삭제", description = "관리자가 뉴스피드 내용 삭제")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable Long id) {
        newsService.deleteNews(id);
        return ResponseEntity.noContent().build();
    }
}
