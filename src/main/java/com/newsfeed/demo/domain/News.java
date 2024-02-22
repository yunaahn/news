package com.newsfeed.demo.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "school_id", nullable = false)
    private Long schoolId;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String title;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    // 생성자, getter, setter 등 생략
}
