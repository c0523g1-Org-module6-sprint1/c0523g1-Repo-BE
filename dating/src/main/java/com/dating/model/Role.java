package com.dating.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", columnDefinition = "varchar(100)", nullable = false)
    private String name;

    @Column(name = "is_deleted", columnDefinition = "bit(1) default 0")
    private int isDeleted;
}
