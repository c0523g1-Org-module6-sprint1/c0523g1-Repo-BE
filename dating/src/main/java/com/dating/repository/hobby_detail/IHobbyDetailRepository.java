package com.dating.repository.hobby_detail;

import com.dating.model.hobby.Hobby;
import com.dating.model.hobby_detail.HobbyDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IHobbyDetailRepository extends JpaRepository<HobbyDetail, Integer> {
    @Transactional
    @Query(value = "SELECT * FROM hobby_detail" , nativeQuery = true)
    List<HobbyDetail> getAllBy();
}
