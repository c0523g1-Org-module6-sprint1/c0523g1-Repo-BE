package com.dating.repository.message;

import com.dating.model.message.MessageStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMessageStatusRepository extends JpaRepository<MessageStatus, Integer> {
}
