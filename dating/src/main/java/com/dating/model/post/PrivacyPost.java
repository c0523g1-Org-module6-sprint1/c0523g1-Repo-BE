package com.dating.model.post;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PrivacyPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(50)",nullable = false)
    private String name;
    @Column(columnDefinition = "boolean default false")
    boolean isDeleted;
    @JsonBackReference
    @OneToMany(mappedBy = "privacyPost")
    private Set<Post> posts;

    public PrivacyPost() {
    }

    public PrivacyPost(String name, boolean isDeleted, Set<Post> posts) {
        this.name = name;
        this.isDeleted = isDeleted;
        this.posts = posts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
