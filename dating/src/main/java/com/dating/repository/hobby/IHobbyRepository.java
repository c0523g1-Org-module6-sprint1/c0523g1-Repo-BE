package com.dating.repository.hobby;

import com.dating.model.gender.Gender;
import com.dating.model.hobby.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IHobbyRepository extends JpaRepository<Hobby, Integer> {
    List<Hobby> getAllBy();

}
