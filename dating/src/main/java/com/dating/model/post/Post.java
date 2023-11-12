package com.dating.model.post;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime date;
    private String content;
    private String image;
    @Column(columnDefinition = "boolean default false")
    boolean isDeleted;

}
