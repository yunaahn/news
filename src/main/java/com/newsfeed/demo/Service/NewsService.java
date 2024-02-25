package com.newsfeed.demo.Service;

import com.newsfeed.demo.Repository.NewsRepository;
import com.newsfeed.demo.domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    //뉴스 저장
    public Long save(News news){
        newsRepository.save(news);

        return news.getId();
    }
    // 뉴스 수정
    public void update(News news) {
        newsRepository.save(news);
    }

    // 뉴스 삭제
    public void delete(News id) {
        newsRepository.delete(id);
    }
}
