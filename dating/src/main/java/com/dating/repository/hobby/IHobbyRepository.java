package com.dating.repository.hobby;

import com.dating.model.gender.Gender;
import com.dating.model.hobby.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IHobbyRepository extends JpaRepository<Hobby, Integer> {
    @Transactional
    @Query(value = "SELECT * FROM hobbies" , nativeQuery = true)
    List<Hobby> getAllBy();

}
