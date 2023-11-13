package com.dating.model.relationship;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.Set;

import javax.persistence.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RelationshipStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", columnDefinition = "varchar(100)", nullable = false)
    private String name;
    @Column(name = "is_deleted", columnDefinition = "bit(1) default 0", nullable = false)
    private boolean isDeleted;



}