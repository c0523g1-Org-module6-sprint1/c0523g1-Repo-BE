package com.dating.model.warning_detail;

import com.dating.model.account.Account;
import com.dating.model.warning.Warning;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class WarningDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime date;
    private Long description;

    private Integer faultAmount;
    private Boolean isDeleted;
    @ManyToOne
    @JoinColumn(name = "warning_id", referencedColumnName = "id")
    private Warning warning;
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;


    public WarningDetails() {
    }

    public WarningDetails(Integer id, LocalDateTime date, Long description, Integer faultAmount, Boolean isDeleted, Warning warning, Account account) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.faultAmount = faultAmount;
        this.isDeleted = isDeleted;
        this.warning = warning;
        this.account = account;
    }
    public void incrementFaultAmount() {
        faultAmount++;
    }
}
