package com.dating.model.gender;

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
@Table(name = "genders")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "is_deleted",columnDefinition = "bit(1) default 0",nullable = false)
    private boolean isDeleted;

    public Gender(int id, boolean isDeleted) {
        this.id = id;
        this.isDeleted = isDeleted;
    }

    public Gender(int id) {
        this.id = id;
    }
}
