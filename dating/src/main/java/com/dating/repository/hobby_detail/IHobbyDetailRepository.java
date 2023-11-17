package com.dating.repository.hobby_detail;

import com.dating.model.hobby.Hobby;
import com.dating.model.hobby_detail.HobbyDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IHobbyDetailRepository extends JpaRepository<HobbyDetail, Integer> {
    @Transactional
    @Query(value = "SELECT * FROM hobby_detail" , nativeQuery = true)
    List<HobbyDetail> getAllBy();

    @Query(value = "select * from hobby_detail where id = :id ",nativeQuery = true)
    List<HobbyDetail> listByID(@Param("id") int id);
}
