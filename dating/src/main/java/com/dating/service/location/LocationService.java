package com.dating.service.location;

import com.dating.model.location.Location;
import com.dating.repository.location.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService implements ILocationService {
    @Autowired
    private ILocationRepository locationRepository;

    @Override
    public List<Location> getAll() {
        return locationRepository.getAllBy();
    }
}
