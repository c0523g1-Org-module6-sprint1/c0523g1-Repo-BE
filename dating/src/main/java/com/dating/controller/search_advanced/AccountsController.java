package com.dating.controller.search_advanced;

import com.dating.dto.search_advanced.SearchAdvanced;
import com.dating.dto.search_advanced.SearchAvancedDto;
import com.dating.service.search_advanced_top_100.IAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/public/search_advanced")
public class AccountsController {

    @Autowired
    private IAccountsService accountsService;

    @PostMapping("/")
    public ResponseEntity<?> searchAdvanced(@RequestBody SearchAdvanced searchAdvanced) {
        List<SearchAvancedDto> accounts = accountsService.getAll(searchAdvanced);
        if (accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(accounts, HttpStatus.OK);
        }
    }
}
