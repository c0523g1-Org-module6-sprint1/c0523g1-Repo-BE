package com.dating.model.update_account;


import javax.persistence.*;

@Entity
public class PackageTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private int days;
    @Column(name = "is_deleted", columnDefinition = "bit(1) default 0")
    private boolean isDeleted;
    @ManyToOne
    @JoinColumn(name = "account_type_id", referencedColumnName = "id")
    private AccountTypes accountTypes;
    public PackageTypes() {
    }

    public PackageTypes(int id, String name, double price, int days, boolean isDeleted, AccountTypes accountTypes) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.days = days;
        this.isDeleted = isDeleted;
        this.accountTypes = accountTypes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public AccountTypes getAccountTypes() {
        return accountTypes;
    }

    public void setAccountTypes(AccountTypes accountTypes) {
        this.accountTypes = accountTypes;
    }
}
