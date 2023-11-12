package com.dating.model.post;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LikeDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime date;
    @Column(columnDefinition = "boolean default false")
    boolean isDeleted ;

    public LikeDetail() {
    }

    public LikeDetail(Integer id, LocalDateTime date, boolean isDeleted) {
        this.id = id;
        this.date = date;
        this.isDeleted = isDeleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
