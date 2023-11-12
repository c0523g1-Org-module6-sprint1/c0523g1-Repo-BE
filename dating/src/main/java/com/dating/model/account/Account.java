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
    @Column(name = "name",columnDefinition = "varchar(100)",nullable = false)
    private String name;
    @Column(name = "user_name",columnDefinition = "varchar(100)",nullable = false)
    private String userName;
    @Column(name = "password",columnDefinition = "varchar(100)",nullable = false)
    private String password;
    @Column(name = "birthday",columnDefinition = "date",nullable = false)
    private String birthday;
    @Column(name = "email",columnDefinition = "varchar(100)",nullable = false)
    private String email;
    @Column(name = "phone_number",columnDefinition = "varchar(15)",nullable = false)
    private String phoneNumber;
    @Column(name = "money",columnDefinition = "double",nullable = false)
    private double money;
    @Column(name = "regis_date",columnDefinition = "date",nullable = false)
    private String regisDate;
    @Column(name = "avatar",columnDefinition = "varchar(100)",nullable = false)
    private String avatar;
    @Column(name = "expire",columnDefinition = "date",nullable = false)
    private String expire;
    @Column(name = "marital_status",columnDefinition = "varchar(100)",nullable = false)
    private String maritalStatus;
    @Column(name = "point",columnDefinition = "int",nullable = false)
    private int point;
    @Column(name = "is_deleted",columnDefinition = "bit(1) default 0",nullable = false)
    private int isDeleted;
}
