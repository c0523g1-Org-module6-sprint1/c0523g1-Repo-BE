package com.dating.model.hobby;

import com.dating.model.hobby_detail.HobbyDetail;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "hobbies")
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "is_deleted",columnDefinition = "bit(1) default 0",nullable = false)
    private boolean isDeleted;

    @JsonBackReference
    @OneToMany(mappedBy = "hobby")
    private Set<HobbyDetail> hobbyDetailSet;

    public Hobby(int id) {
        this.id = id;
    }
}
