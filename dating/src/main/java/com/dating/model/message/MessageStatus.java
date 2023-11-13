package com.dating.model.message;

import com.dating.model.account.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "message_status")
public class MessageStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalTime offlineMoment;
    private Boolean isDeleted;
    @JsonBackReference
    @OneToMany(mappedBy = "messageStatus")
    private List<Account> accounts;

    public MessageStatus() {
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

    public LocalTime getOfflineMoment() {
        return offlineMoment;
    }

    public void setOfflineMoment(LocalTime offlineMoment) {
        this.offlineMoment = offlineMoment;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
