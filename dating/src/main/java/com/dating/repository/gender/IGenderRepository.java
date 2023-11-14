package com.dating.repository.gender;

import com.dating.model.gender.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IGenderRepository extends JpaRepository<Gender, Integer> {
    @Transactional
    @Query(value = "SELECT * FROM genders" , nativeQuery = true)
    List<Gender> getAllBy();
}
