package com.dating.repository.gender;

import com.dating.model.gender.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGenderRepository extends JpaRepository<Gender, Integer> {
    List<Gender> getAllBy();
}
