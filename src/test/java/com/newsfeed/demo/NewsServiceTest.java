package com.newsfeed.demo;
import com.newsfeed.demo.Service.NewsService;
import com.newsfeed.demo.domain.News;
import com.newsfeed.demo.Repository.NewsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NewsServiceTest {

    @Mock
    private NewsRepository newsRepository;

    @InjectMocks
    private NewsService newsService;

    @Test
    public void testSaveNews() {
        News news = new News();
        news.setTitle("Test News");
        news.setContent("This is a test news");

       // when(newsRepository.save(news)).thenReturn(1L); // Assuming the saved news has an ID of 1L

        Long savedNewsId = newsService.save(news);

        verify(newsRepository).save(news);
        assert(savedNewsId.equals(1L));
    }

    @Test
    public void testUpdateNews() {
        News news = new News();
        news.setId(1L);
        news.setTitle("Updated News");
        news.setContent("This news has been updated");

        newsService.update(news);

        verify(newsRepository).update(news);
    }

    @Test
    public void testDeleteNews() {
        Long newsId = 1L;

        newsService.delete(newsId);

        verify(newsRepository).delete(newsId);
    }
}