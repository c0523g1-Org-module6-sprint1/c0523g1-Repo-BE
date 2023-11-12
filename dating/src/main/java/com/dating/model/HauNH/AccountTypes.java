package com.dating.model.HauNH;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AccountTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "is_deleted", columnDefinition = "bit(1) default 0")
    private boolean isDeleted;
    @JsonBackReference
    @OneToMany(mappedBy = "accountTypes")
    private Set<PackageTypes> packageTypesSet;
    public AccountTypes() {
    }

    public AccountTypes(int id, String name, boolean isDeleted, Set<PackageTypes> packageTypesSet) {
        this.id = id;
        this.name = name;
        this.isDeleted = isDeleted;
        this.packageTypesSet = packageTypesSet;
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Set<PackageTypes> getPackageTypesSet() {
        return packageTypesSet;
    }

    public void setPackageTypesSet(Set<PackageTypes> packageTypesSet) {
        this.packageTypesSet = packageTypesSet;
    }
}
