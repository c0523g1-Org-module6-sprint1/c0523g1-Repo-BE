package com.dating.controller.search_advanced;

import com.dating.dto.search_advanced.SearchAvancedDto;
import com.dating.model.account.Account;
import com.dating.service.search_advanced_top_100.IAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/public/search_advanced")
public class AccountsController {
    @Autowired
    private IAccountsService accountsService;

    @GetMapping
//    @GetMapping("/{name}/{birthday}/{genderId}/{locationId}/{jobId}/{hobbyDetailId}")
    public ResponseEntity<List<SearchAvancedDto>> searchAdvanced(
            @RequestParam (name="name", defaultValue = "",required = false) String name,
            @RequestParam (name="birthday", defaultValue = "",required = false) String birthday,
            @RequestParam (name="genderId", defaultValue = "1",required = false) int genderId,
            @RequestParam (name = "locationId", defaultValue = "1",required = false) int locationId,
            @RequestParam (name = "jobId", defaultValue = "1",required = false) int jobId,
            @RequestParam(name = "hobbyDetailId", defaultValue = "1",required = false)  int hobbyDetailId

//            @RequestParam (name="name") String name,
//            @RequestParam (name="birthday") String birthday,
//            @RequestParam (name="genderId") int genderId,
//            @RequestParam (name = "locationId") int locationId,
//            @RequestParam (name = "jobId") int jobId,
//            @RequestParam(name = "hobbyDetailId")  int hobbyDetailId
            ) {
        List<SearchAvancedDto> accounts = accountsService.getAll(name, birthday, genderId, locationId, jobId,hobbyDetailId);
        System.out.println("I");
        if (accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(accounts, HttpStatus.OK);
        }
    }
}
