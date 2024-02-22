package com.newsfeed.demo.Repository;

import com.newsfeed.demo.domain.School;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class SchoolRepository {

    @PersistenceContext
    private EntityManager em;

    public  void save(School school){
        em.persist(school);
    }
}
