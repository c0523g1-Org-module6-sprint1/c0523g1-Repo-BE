package com.dating.repository.relationship;

import com.dating.model.relationship.Relationships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ISendInvitedRepository extends JpaRepository<Relationships,Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into relationships(date_request,relationship_status_id,sender_account_id,receiver_account_id)" +
                   " values (:dateRequest,:status,:sendAccountID,:receiveAccountID)",nativeQuery = true)
    void saveInvitedFriend(@Param("dateRequest") LocalDateTime dateRequest,
                           @Param("status") int status,
                           @Param("sendAccountID") int sendAccountID,
                           @Param("receiveAccountID") int receiveAccountID);
}
