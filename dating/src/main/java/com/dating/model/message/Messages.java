package com.dating.model.message;
import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String path;
    private Boolean isDeleted;
}
