package com.dating.repository.location;

import com.dating.model.hobby.Hobby;
import com.dating.model.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ILocationRepository extends JpaRepository<Location, Integer> {
    @Transactional
    @Query(value = "SELECT * FROM location" , nativeQuery = true)
    List<Location> getAllBy();

}
