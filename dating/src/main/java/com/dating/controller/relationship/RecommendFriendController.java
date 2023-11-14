package com.dating.HauNH_controller.relationship;

import com.dating.model.account.Account;
import com.dating.model.relationship.RelationshipStatus;
import javax.persistence.*;
import java.time.LocalDateTime;


public class RecommendFriendController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dateRequest;

    private boolean isDeleted;

    private RelationshipStatus relationshipStatus;
    private Account senderAccount;

    private Account receiverAccount;

}
