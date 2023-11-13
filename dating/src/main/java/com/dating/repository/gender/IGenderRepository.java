package com.dating.repository.gender;

import com.dating.model.gender.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenderRepository extends JpaRepository<Gender, Integer> {
}
