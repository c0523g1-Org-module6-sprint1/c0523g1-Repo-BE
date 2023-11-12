package com.dating.model.warning_detail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class WarningDetails {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private Long description;
    private boolean isDeleted;

    public WarningDetails() {
    }

    public WarningDetails(int id, LocalDate date, Long description, boolean isDeleted) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.isDeleted = isDeleted;
    }
}
