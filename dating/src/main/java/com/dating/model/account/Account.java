package com.dating.model.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String userName;
    private String password;
    private String birthday;
    private String email;
    private String phoneNumber;
    private double money;
    private String regisDate;
    private String avatar;
    private String expire;
    private String maritalStatus;
    private int point;




}
