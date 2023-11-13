package com.dating.model.gift;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;


@Entity
public class Gift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String image;
    private int price;
    private boolean isDelete;
    @JsonBackReference
    @OneToMany(mappedBy = "gift")
   private Set<GiftRecord> giftRecords;

    public Gift() {
    }

    public Gift(int id, String name, String image, int price, int isDelete, Set<GiftRecord> giftRecords) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.isDelete = isDelete;
        this.giftRecords = giftRecords;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public Set<GiftRecord> getGiftRecords() {
        return giftRecords;
    }

    public void setGiftRecords(Set<GiftRecord> giftRecords) {
        this.giftRecords = giftRecords;
    }
}
