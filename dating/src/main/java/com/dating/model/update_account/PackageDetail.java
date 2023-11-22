package com.dating.model.update_account;

import com.dating.model.account.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PackageDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "account_types_id",referencedColumnName = "id")
    private AccountTypes accountTypes;
    @Column(name = "is_deleted", columnDefinition = "bit(1) default 0")
    private boolean isDeleted;

//    public PackageDetail() {
//    }
//
//    public PackageDetail(int id, Account account, AccountTypes accountTypes) {
//        this.id = id;
//        this.account = account;
//        this.accountTypes = accountTypes;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
//
//    public AccountTypes getAccountTypes() {
//        return accountTypes;
//    }
//
//    public void setAccountTypes(AccountTypes accountTypes) {
//        this.accountTypes = accountTypes;
//    }
}
