package com.dating.controller.security;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
public class SecurityAuthorizationTest {

    /**
     * method testing member authorization
     * Create ThienBB
     * Date 13-11-2023
     * param N/A
     * return String "member author"
     */
    @RequestMapping({"/member/test"})
    public String member() {
        return "Member author";
    }

    /**
     * method testing admin authorization
     * Create ThienBB
     * Date 13-11-2023
     * param N/A
     * return String "Admin author"
     */
    @RequestMapping({"/admin/test"})
    public String admin() {
        return "Admin author";
    }

    /**
     * method testing public authorization
     * Create ThienBB
     * Date 13-11-2023
     * param N/A
     * return String "public author"
     */
    @RequestMapping({"/public/test"})
    public String publicLink() {
        return "Public author";
    }

}
