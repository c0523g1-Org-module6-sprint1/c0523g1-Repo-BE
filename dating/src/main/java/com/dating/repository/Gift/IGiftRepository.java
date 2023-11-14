package com.dating.repository.Gift;
import com.dating.model.gift.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IGiftRepository extends JpaRepository<Gift, Integer> {
    /**
     * method getAll
     * Create QuyNP
     * Date 13-11-2023
     * return List<Gift>
     */
    @Query(value = "select * from Gift where is_deleted = 0 ", nativeQuery = true)
    List<Gift> getAll();
}
