package com.dating.model.warning_detail;

import com.dating.model.account.Account;
import com.dating.model.warning.Warning;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class WarningDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private Long description;
    private boolean isDeleted;
    @ManyToOne
    @JoinColumn(name = "warning_id", referencedColumnName = "id")
    private Warning warning;
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;


    public WarningDetails() {
    }

    public WarningDetails(int id, LocalDate date, Long description, boolean isDeleted) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.isDeleted = isDeleted;
    }
}
