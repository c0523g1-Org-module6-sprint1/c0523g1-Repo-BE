package com.dating.model.gift;

import com.dating.model.account.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class GiftRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private LocalDate time;
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



    public GiftRecord() {
    }


}
