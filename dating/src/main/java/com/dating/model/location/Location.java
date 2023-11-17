package com.dating.model.location;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "is_deleted",columnDefinition = "bit(1) default 0",nullable = false)
    private boolean isDeleted;

    public Location(int id, boolean isDeleted) {
        this.id = id;
        this.isDeleted = isDeleted;
    }

    public Location(int id) {
        this.id = id;
    }
}
