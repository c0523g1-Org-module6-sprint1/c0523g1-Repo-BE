package com.dating.model.message;
import com.dating.model.account.Account;

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
    @ManyToOne
    @JoinColumn(name = "senderAccountId", referencedColumnName = "id")
    private Account senderAccount;
    @ManyToOne
    @JoinColumn(name = "receiveAccountId", referencedColumnName = "id")
    private Account receiverAccount;

}
