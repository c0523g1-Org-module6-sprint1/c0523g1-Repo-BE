package com.dating.repository.Gift;
import com.dating.model.gift.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IGiftRepository extends JpaRepository<Gift, Integer> {
    /**
     * method getAll
     * Create QuyNP
     * Date 13-11-2023
     * return List<Gift>
     */
    @Query(value = "SELECT * FROM gift WHERE is_delete = false", nativeQuery = true)
    List<Gift> getAll();

    /**
     * method findGift
     * Create QuyNP
     * Date 13-11-2023
     * return price
     */
    @Query(value = "SELECT gift.price FROM gift  WHERE gift.id = :id",nativeQuery = true)
    int findPrice(@Param("id") int id);
}
