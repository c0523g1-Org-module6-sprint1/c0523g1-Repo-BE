package com.dating.repository.message;

import com.dating.model.message.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMessageRepository extends JpaRepository<Messages, Integer> {
//    List<Messages> findMessagesBySenderAccount_IdOrReceiverAccount_Id(Integer senderId, Integer receiverId);


}
