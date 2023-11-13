package com.dating.model.post;

import com.dating.model.account.Account;
import com.dating.model.comment.Comments;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

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
    @ManyToOne
    @JoinColumn(name = "privacy_post_id",referencedColumnName = "id")
    private PrivacyPost privacyPost;
    @ManyToOne
    @JoinColumn (name = "account_id",referencedColumnName = "id")
    private Account account;
    @JsonBackReference
    @OneToMany (mappedBy = "post")
    private Set<LikeDetail> likeDetails;

    @JsonBackReference
    @OneToMany(mappedBy = "post")
    private Set<Comments> comments;

    public Post() {
    }

    public Post(LocalDateTime date, String content, String image, boolean isDeleted, PrivacyPost privacyPost, Account account, Set<LikeDetail> likeDetails, Set<Comments> comments) {
        this.date = date;
        this.content = content;
        this.image = image;
        this.isDeleted = isDeleted;
        this.privacyPost = privacyPost;
        this.account = account;
        this.likeDetails = likeDetails;
        this.comments = comments;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public PrivacyPost getPrivacyPost() {
        return privacyPost;
    }

    public void setPrivacyPost(PrivacyPost privacyPost) {
        this.privacyPost = privacyPost;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<LikeDetail> getLikeDetails() {
        return likeDetails;
    }

    public void setLikeDetails(Set<LikeDetail> likeDetails) {
        this.likeDetails = likeDetails;
    }

    public Set<Comments> getComments() {
        return comments;
    }

    public void setComments(Set<Comments> comments) {
        this.comments = comments;
    }
}
