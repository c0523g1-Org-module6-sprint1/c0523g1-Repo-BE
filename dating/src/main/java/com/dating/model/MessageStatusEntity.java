package com.dating.model;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "message_status")
public class MessageStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalTime offlineMoment;
    private Boolean isDeleted;
}
