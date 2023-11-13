package com.dating.repository.Gift;

import com.dating.model.gift.GiftRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IGiftRecordRepository extends JpaRepository<GiftRecord, Integer> {

    @Query(value = "select * from Gift where is_deleted = 0 ", nativeQuery = true)
    void crate(GiftRecord giftRecord);

}
