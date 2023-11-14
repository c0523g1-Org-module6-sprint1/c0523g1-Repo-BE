package com.dating.model.gift;

import com.dating.model.account.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GiftRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private LocalDateTime time;
    private boolean isDelete;
    @ManyToOne
    @JoinColumn(name = "gift_id",referencedColumnName = "id")
    private Gift gift;
    @ManyToOne
    @JoinColumn(name = "accountSender_id",referencedColumnName = "id")
    private Account accountSender;
    @ManyToOne
    @JoinColumn(name = "accountReceiver_id",referencedColumnName = "id")
    private Account accountReceiver;



}
