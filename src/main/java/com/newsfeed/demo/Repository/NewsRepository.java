package com.newsfeed.demo.Repository;

import com.newsfeed.demo.domain.News;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class NewsRepository {

    @PersistenceContext
    private EntityManager em;


    public void save(News news){
        em.persist(news);
    }

    public News findById(Long id){
        return em.find(News.class, id);
    }


    public void update(News updatedNews){
        em.merge(updatedNews);
    }


    public void delete(Long id){
        News news = em.find(News.class, id);
        if (news != null) {
            em.remove(news);
        }
    }
}
