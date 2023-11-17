package com.dating.controller.post;

import com.dating.model.post.PrivacyPost;
import com.dating.service.post.IPrivacyPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/public/privacy-post")
public class PrivacyPostController {
    @Autowired
    private IPrivacyPostService iPrivacyPostService;
    @GetMapping("")
    public ResponseEntity<List<PrivacyPost>> showListPublic() {
        List<PrivacyPost> privacyPost = iPrivacyPostService.showListPrivacyPost();
        if (privacyPost.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(privacyPost, HttpStatus.OK);
        }
    }

}
