package com.dating.repository.Gift;

import com.dating.dto.GiftRecordDto.QuantityDto;
import com.dating.model.gift.GiftRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IGiftRecordRepository extends JpaRepository<GiftRecord, Integer> {
    /**
     * method create
     * Create QuyNP
     * Date 13-11-2023
     */

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gift_record (quantity, time, account_receiver_id, account_sender_id, gift_id, is_delete) VALUES (:quantity, NOW(), :receiverAccountId, :senderAccountId, :giftId, false)", nativeQuery = true)
    void insertGiftRecord(@Param("quantity") int quantity, @Param("receiverAccountId") Integer receiverAccountId, @Param("senderAccountId") Integer senderAccountId, @Param("giftId") int giftId);
    @Query(value = "SELECT * FROM gift_record WHERE is_delete = false AND account_receiver_id = :accountId GROUP BY gift_record.id ORDER BY id DESC", nativeQuery = true)
    List<GiftRecord> getAll(@Param("accountId") Integer accountId);
    @Query(value = "SELECT gr.gift_id as giftId, SUM(gr.quantity) as totalQuantity, g.image as images " +
            "FROM gift_record gr " +
            "JOIN gift g ON gr.gift_id = g.id " +
            "WHERE account_receiver_id = :accountId " +
            "GROUP BY gr.gift_id, g.image", nativeQuery = true)
    List<QuantityDto> getQuantity(@Param("accountId") Integer accountId);

}
