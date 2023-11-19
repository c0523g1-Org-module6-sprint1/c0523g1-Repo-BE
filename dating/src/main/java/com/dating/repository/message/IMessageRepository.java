package com.dating.repository.message;

import com.dating.model.message.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IMessageRepository extends JpaRepository<Messages, Integer> {
    /**
     * method findMessageByAccountId
     * Create ThangLQ
     * Date 13-11-2023
     * return List<Messages>
     */
    @Query(nativeQuery = true, value = "select * from messages where is_deleted = 0 and (receive_account_id = :id or sender_account_id = :id)")
    List<Messages> findMessageByAccountId (@Param("id") Integer id);

    /**
     * method isContacted
     * Create ThangLQ
     * Date 13-11-2023
     * return Messages
     */
    @Query(nativeQuery = true, value = "select * from messages where (receive_account_id = :reid and sender_account_id = :seid) or (receive_account_id = :seid and sender_account_id = :reid)")
    Messages isContacted (@Param("reid") Integer receiverId, @Param("seid") Integer senderId);

    /**
     * method getMessageById
     * Create ThangLQ
     * Date 13-11-2023
     * return Messages
     */
    @Query(nativeQuery = true, value = "select * from messages where (id = :id and is_deleted = 0)")
    Messages getMessageById (@Param("id") Integer Id);

    /**
     * method delMessage
     * Create ThangLQ
     * Date 13-11-2023
     * return void
     */
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update messages set is_deleted = 1 where id = :id")
    void delMessage(@Param("id") Integer id);

    /**
     * method createMessage
     * Create ThangLQ
     * Date 13-11-2023
     * return void
     */
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into messages (sender_account_id, receive_account_id, path) values (:reid, :seid, :path)")
    void createMessage(@Param("reid") Integer receiverId, @Param("seid") Integer senderId, @Param("path") String path);

    /**
     * method getLastMess
     * Create ThangLQ
     * Date 13-11-2023
     * return Messages
     */
    @Query(nativeQuery = true, value = "select * from messages where id = LAST_INSERT_ID()")
    Messages getLastMess();
}
