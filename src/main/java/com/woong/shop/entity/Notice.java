package com.woong.shop.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(length = 500)
    public String title;
    @Column(columnDefinition = "TEXT")
    public String content;
    @Column(nullable = false)
    public Date uploadDate;
    @Column(nullable = false)
    public Integer viewCount;

}
