package com.dating.controller.search_name;

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
public class SearchNameRestController {
    @Autowired
    private ISearchNameService accountService;

    /**
     * method searchByName
     * Create LienDTM
     * Date 13-11-2023
     * param String name
     * return new Object: SearchNameDto
     */
    @GetMapping("/public/search-name/{name}")
    public ResponseEntity<List<SearchNameDto>> searchByName(@PathVariable String name){
        List<SearchNameDto> accounts = accountService.searchByName(name);
        if(accounts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(accounts,HttpStatus.OK);
        }
    }
}
