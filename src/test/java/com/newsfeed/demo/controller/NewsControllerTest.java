package com.newsfeed.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newsfeed.demo.domain.News;
import com.newsfeed.demo.service.NewsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.awaitility.Awaitility.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NewsController.class)
public class NewsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NewsService newsService;

    @Test
    public void getAllNewsTest() throws Exception {

        News news = new News();
        news.setTitle("Test News");
        news.setContent("This is a test news");

        when(newsService.getAllNews()).thenReturn(Collections.singletonList(news));


        mockMvc.perform(MockMvcRequestBuilders.get("/news")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("Test News"));




    }

    @Test
    public void getNewsByIdTest() throws Exception {

        Long newsId = 1L;
        News news = new News();
        news.setId(newsId);
        news.setTitle("Test News");
        news.setContent("This is a test news");

        when(newsService.getNewsById(newsId)).thenReturn(news);


        mockMvc.perform(MockMvcRequestBuilders.get("/news/{id}" + newsId))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.id").value(newsId))
                .andExpect((ResultMatcher) jsonPath("$.title").value("Test News"));
    }

    @Test
    public void addNewsTest() throws Exception {

        News news = new News();
        news.setTitle("Test News");
        news.setContent("This is a test news");

        when(newsService.addNews(Mockito.any(News.class))).thenReturn(news);


        mockMvc.perform(MockMvcRequestBuilders.post("/news")
                        .content(asJsonString(news))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Test News"));
    }

    @Test
    public void updateNewsTest() throws Exception {

        Long id = 1L;
        News news = new News();
        news.setId(id);
        news.setTitle("Updated Test News");
        news.setContent("This is an updated test news");

        when(newsService.updateNews(Mockito.anyLong(), Mockito.any(News.class))).thenReturn(news);


        mockMvc.perform(MockMvcRequestBuilders.put("/news/{id}", id)
                        .content(asJsonString(news))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Updated Test News"));
    }

    @Test
    public void deleteNewsTest() throws Exception {

        Long id = 1L;


        mockMvc.perform(MockMvcRequestBuilders.delete("/news/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }


    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
