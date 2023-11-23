package com.dating.controller.search_name;

import com.dating.dto.search_name.MainPageDto;
import com.dating.dto.search_name.SearchNameDto;
import com.dating.service.search_name.ISearchNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class SearchNameController {
    @Autowired
    private ISearchNameService searchNameService;

    /**
     * method searchByName
     * Create LienDTM
     * Date 13-11-2023
     * param String name
     * return new Object: SearchNameDto
     */
    @GetMapping("/public/search-name/{name}")
    public ResponseEntity<List<SearchNameDto>> searchByName(@PathVariable String name){
        List<SearchNameDto> accounts = searchNameService.searchByName(name);
        if(accounts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            em hay làm NO_CONTENT nhưng để khớp với checklist nên để BAD_REQUEST
        }else {
            return new ResponseEntity<>(accounts,HttpStatus.OK);
        }
    }
    @GetMapping("/public/search-name/user/{userName}")
    public ResponseEntity<MainPageDto> findByUserName(@PathVariable String userName){
        MainPageDto mainPageDto = searchNameService.findByUserName(userName);
        if(userName == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(mainPageDto,HttpStatus.OK);
        }
    }
}
