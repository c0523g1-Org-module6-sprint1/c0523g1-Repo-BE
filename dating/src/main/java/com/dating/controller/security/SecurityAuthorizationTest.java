package com.dating.controller.security;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
public class SecurityAuthorizationTest {

    @RequestMapping({"/member/test"})
    public String member() {
        return "Member author";
    }

    @RequestMapping({"/admin/test"})
    public String admin() {
        return "Admin author";
    }

    @RequestMapping({"/public/test"})
    public String publicLink() {
        return "Public author";
    }

}
