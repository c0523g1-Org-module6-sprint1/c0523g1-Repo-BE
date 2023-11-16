package com.dating.model.job;

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
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "is_deleted",columnDefinition = "bit(1) default 0",nullable = false)
    private boolean isDeleted;

    public Job(int id, boolean isDeleted) {
        this.id = id;
        this.isDeleted = isDeleted;
    }
}
