package com.dating.repository.location;

import com.dating.model.hobby.Hobby;
import com.dating.model.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILocationRepository extends JpaRepository<Location, Integer> {
    List<Location> getAllBy();

}
