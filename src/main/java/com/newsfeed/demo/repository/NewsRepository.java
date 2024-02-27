package com.newsfeed.demo.repository;

import com.newsfeed.demo.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    List<News> findBySchoolIdIn(List<Long> subscribedSchoolIds);
}
