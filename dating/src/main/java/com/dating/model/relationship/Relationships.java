package com.dating.model.relationship;
import com.dating.model.account.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;



@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Relationships {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "date_request", columnDefinition = "datetime", nullable = false)
    private LocalDateTime dateRequest;
    @Column(name = "is_deleted", columnDefinition = "bit(1) default 0", nullable = false)
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "relationship_status_id", referencedColumnName = "id",nullable = false)
    private RelationshipStatus relationshipStatus;

    @OneToOne
    @JoinColumn(name = "sender_account_id", referencedColumnName = "id",nullable = false)
    private Account senderAccount;

    @OneToOne
    @JoinColumn(name = "receiver_account_id", referencedColumnName = "id",nullable = false)
    private Account receiverAccount;

}
