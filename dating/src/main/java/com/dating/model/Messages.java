package com.dating.model;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private String type;
    private LocalDateTime release;
    private Boolean seen;
    private Boolean isDeleted;
}
