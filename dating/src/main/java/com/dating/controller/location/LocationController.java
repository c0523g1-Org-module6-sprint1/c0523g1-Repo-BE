package com.dating.controller.location;

import com.dating.model.location.Location;
import com.dating.service.location.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/public/locations")
public class LocationController {
    @Autowired
    private ILocationService locationService;
    @GetMapping("")
    public ResponseEntity<List<Location>> getAll(){
        List<Location> locations = locationService.getAll();
        if(locations.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(locations,HttpStatus.OK);
        }
    }
}
