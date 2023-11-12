package com.dating.model.gift;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class GiftRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private LocalDate time;
    private boolean isDelete;
    @ManyToOne
    @JoinColumn(name = "gift_id",referencedColumnName = "id")
    private Gift gift;

    public GiftRecord() {
    }

    public GiftRecord(int id, int quantity, LocalDate time, boolean isDelete, Gift gift) {
        this.id = id;
        this.quantity = quantity;
        this.time = time;
        this.isDelete = isDelete;
        this.gift = gift;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Gift getGift() {
        return gift;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }
}
