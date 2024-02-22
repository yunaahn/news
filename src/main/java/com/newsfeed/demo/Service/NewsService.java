package com.newsfeed.demo.Service;

import com.newsfeed.demo.Repository.NewsRepository;
import com.newsfeed.demo.domain.News;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

    private NewsRepository newsRepository;

    //뉴스 저장
    public Long save(News news){
        newsRepository.save(news);

        return news.getId();
    }
    // 뉴스 수정
    public void update(News news) {
        newsRepository.update(news);
    }

    // 뉴스 삭제
    public void delete(Long id) {
        newsRepository.delete(id);
    }
}
