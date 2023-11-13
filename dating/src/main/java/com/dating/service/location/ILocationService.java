package com.dating.service.location;

import com.dating.model.location.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILocationService {
    List<Location> getAll();

}
