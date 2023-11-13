package com.dating.repository.hobby;

import com.dating.model.hobby.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHobbyRepository extends JpaRepository<Hobby, Integer> {
}
