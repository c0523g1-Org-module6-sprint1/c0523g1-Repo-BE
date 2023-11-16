package com.dating.repository.warning_detail;

import com.dating.model.warning_detail.WarningDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IWarningDetailRepository extends JpaRepository<WarningDetails,Integer> {
    @Query(value = "select * from warning_detail where id :id ", nativeQuery = true)
    WarningDetails findByid(@Param("id") Integer id);




}
