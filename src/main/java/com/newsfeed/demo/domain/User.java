package com.newsfeed.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter @Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long schoolId;

    @Column(nullable = false)
    private int user_type;

    @ElementCollection
    private List<Long> subscribedSchoolIds;



}
