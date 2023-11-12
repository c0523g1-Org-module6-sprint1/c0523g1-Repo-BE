package com.dating.model.update_account;

import javax.persistence.*;

@Entity
public class PackageDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public PackageDetail() {
    }

}
